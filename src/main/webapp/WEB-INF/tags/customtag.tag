<%@ tag language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ attribute name="addressType" required="true" %>

<jsp:useBean id="address" scope="request" class="beans.AddressBean"/>

<table cellpadding="0" cellspacing="0" border="0">
    <tr>
        <td align="right" width="70"><b>Улица 1</b>&nbsp;</td>
        <td><input type="text" name="${addressType}_line1" size="30" maxlength="100" value="${address.line1}"></td>
    </tr>
    <tr>
        <td align="right" width="70"><b>Улица 2</b>&nbsp;</td>
        <td><input type="text" name="${addressType}_line2" size="30" maxlength="100" value="${address.line2}"></td>
    </tr>
    <tr>
        <td align="right"><b>Город</b>&nbsp;</td>
        <td><input type="text" name="${addressType}_city" size="30" value="${address.city}"></td>
    </tr>
    <tr>
        <td align="right"><b>Штат</b>&nbsp;</td>
        <td>
            <select name="${addressType}_state">
                <option value=""></option>
                <option value="AL" <% if (address.getState().equals("AL")) out.println(" selected "); %>>Alabama</option>
                <option value="AK" <% if (address.getState().equals("AK")) out.println(" selected "); %>>Alaska</option>
                <option value="AZ" <% if (address.getState().equals("AZ")) out.println(" selected "); %>>Arizpna</option>
                <option value="AR" <% if (address.getState().equals("AR")) out.println(" selected "); %>>Arkanzas</option>
                <option value="CA" <% if (address.getState().equals("CA")) out.println(" selected "); %>>California</option>
                <option value="CO" <% if (address.getState().equals("CO")) out.println(" selected "); %>>Colorado</option>
                <option value="CT" <% if (address.getState().equals("CT")) out.println(" selected "); %>>Connecticut</option>
                <option value="DC" <% if (address.getState().equals("DC")) out.println(" selected "); %>>District of Columbia</option>
                <option value="FL" <% if (address.getState().equals("FL")) out.println(" selected "); %>>Florida</option>
            </select>
        </td>
    </tr>
    <tr>
        <td align="right"><b>Zip code</b></td>
        <td><input type="text" name="${addressType}_zip" size="5" value="${address.zip}"></td>
    </tr>
</table>
