package com.xupt.bookshop.web.controller;

import com.xupt.bookshop.common.utils.PaymentUtils;
import com.xupt.bookshop.dao.OrderDao;
import com.xupt.bookshop.model.enums.OrderState;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**借助易宝支付实现支付
 * Created by zhangge on 16-5-5.
 */
@Controller
@RequestMapping("/pay")
public class PayController {

    @Resource
    OrderDao orderDao;
    @RequestMapping("/paySend")
    public String  paymentSend(HttpServletRequest request,HttpServletResponse response){

        String accountID = "10001126856";
        //测试商户：密钥
        String keyValue = "69cl522AV6q613Ii4W6u8K6XuW8vM1N6bFgyv769220IuYe9u37N4y7rI4Pl";
        //测试商户：商户接收支付成功数据的地址
        String accountCallbackURL = "http://127.0.0.1:8083/pay/payResult";

        String orderID = request.getParameter("orderID");        //获取订单号
        String amount = request.getParameter("amount");          //获取支付金额
        String accountBankID = request.getParameter("pd_FrpId"); //获取用户所选择的银行
        String businessType = "Buy";  //业务类型。Buy为在线支付
        String currency = "CNY";      //交易币种。CNY为人民币
        String productDesc = "";      //商品描述
        String productCategory = "";  //商品种类
        String productID = "";        //商品ID
        String addressFlag = "0";     //送货地址。0为不需要，1为需要
        String accountMoreInfo = "";  //商户扩展信息
        String pr_NeedResponse = "0"; //应答机制

        String md5hmac = PaymentUtils.buildHmac(
                businessType, accountID, orderID, amount, currency, productID, productCategory,
                productDesc, accountCallbackURL, addressFlag, accountMoreInfo, accountBankID,
                pr_NeedResponse, keyValue);

        request.setAttribute("businessType", businessType);
        request.setAttribute("accountID", accountID);
        request.setAttribute("orderID", orderID);
        request.setAttribute("amount", amount);
        request.setAttribute("currency", currency);
        request.setAttribute("productID", productID);
        request.setAttribute("productCategory", productCategory);
        request.setAttribute("productDesc", productDesc);
        request.setAttribute("accountCallbackURL", accountCallbackURL);
        request.setAttribute("addressFlag", addressFlag);
        request.setAttribute("accountMoreInfo", accountMoreInfo);
        request.setAttribute("accountBankID", accountBankID);
        request.setAttribute("needResponse", pr_NeedResponse);
        request.setAttribute("md5hmac", md5hmac);
        return "connection";
    }


    @RequestMapping("/payResult")
    public String  payResult(HttpServletRequest request,HttpServletResponse response){
        //测试商户：商家ID
        String p1_MerId = "10000432521";
        //测试商户：商家密钥
        String keyValue = "8UPp0KE8sq73zVP370vko7C39403rtK1YwX40Td6irH216036H27Eb12792t";

        String r0_Cmd = request.getParameter("r0_Cmd");      //业务类型
        String r1_Code = request.getParameter("r1_Code");    //扣款结果。1:扣款成功
        String r2_TrxId = request.getParameter("r2_TrxId");  //易宝交易订单号
        String r3_Amt = request.getParameter("r3_Amt");      //扣款金额。交易结束后，易宝交易系统将实际扣款金额返回给商户
        String r4_Cur = request.getParameter("r4_Cur");      //交易币种。人民币为CNY
        String r5_Pid = request.getParameter("r5_Pid");      //商品ID
        String r6_Order = request.getParameter("r6_Order");  //商户订单号
        String r7_Uid = request.getParameter("r7_Uid");      //易宝会员ID
        String r8_MP = request.getParameter("r8_MP");        //商户扩展信息。可任意填写1K的字符串，交易返回时将原样返回
        String r9_BType = request.getParameter("r9_BType");  //交易结果通知类型。1:交易成功回调(浏览器重定向)，2:交易成功主动通知(服务器点对点通讯)
        String hmac = request.getParameter("hmac");          //MD5交易签名

        boolean result = PaymentUtils.verifyCallback(
                hmac, p1_MerId, r0_Cmd, r1_Code, r2_TrxId, r3_Amt, r4_Cur,
                r5_Pid, r6_Order, r7_Uid, r8_MP, r9_BType, keyValue);
        if (result) {
            if ("1".equals(r1_Code)) {
                StringBuffer message = new StringBuffer();
                message.append("订单号为：" + r6_Order + " 的订单支付成功，"); //此时数据库中订单支付状态应为已支付，否则容易出现"无限刷点卡"的BUG
                message.append("用户支付了" + r3_Amt + "元。<br/>");
                message.append("交易结果通知类型：");
                if ("1".equals(r9_BType)) {
                    message.append("浏览器重定向。<br/>");
                } else if ("2".equals(r9_BType)) {
                    message.append("易宝支付网关后台程序通知。<br/>");
                }
                message.append("易宝订单系统中的订单号为：" + r2_TrxId);
                request.setAttribute("message", message);
            } else {
                request.setAttribute("message", "用户支付失败");
            }
        } else {
            request.setAttribute("message", "数据来源不合法");
        }
       //更改订单状态是支付完成
        orderDao.updateOrderStatus(OrderState.ORDER_PAY_SUCCESS);
       return "payresult";
    }

}
