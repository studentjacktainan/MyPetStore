<%@ include file="../common/top.jsp"%>

<div id="Catalog"><form action="orderAction" method="post">
    <table>
        <tr>
            <th colspan=2>Payment Details</th>
        </tr>
        <tr>
            <td>Card Type:</td>
            <td><label>
                <select name="order.cardType">
                    <options-collection
                            collection="${sessionScope.creditCardTypes}"></options-collection>
                </select>
            </label></td>
        </tr>
        <tr>
            <td>Card Number:</td>
            <td><input type="text" name="cardNumber"> </td>
        </tr>
        <tr>
            <td>Expire Date (MM/YYYY):</td>
            <td><input type="text" name="expiryDate"></td>
        </tr>
        <tr>
            <th colspan=2>Billing Address</th>
        </tr>

        <tr>
            <td>First name:</td>
            <td><input type="text" name="firstName"></td>
        </tr>
        <tr>
            <td>Last name:</td>
            <td><label>
                <input type="text" name="lasttName">
            </label></td>
        </tr>
        <tr>
            <td>Address 1:</td>
            <td><input type=" text" name="Address1" ></td>
        </tr>
        <tr>
            <td>Address 2:</td>
            <td><input type="text"  name="Address2" /></td>
        </tr>
        <tr>
            <td>City:</td>
            <td><input type="text" name="City" /></td>
        </tr>
        <tr>
            <td>State:</td>
            <td><input type="text" name="State" /></td>
        </tr>
        <tr>
            <td>Zip:</td>
            <td><input type="text" name="Zip" /></td>
        </tr>
        <tr>
            <td>Country:</td>
            <td><input type="text" name="Country" /></td>
        </tr>

        <tr>
            <td colspan=2><input type="checkbox" name="shippingAddressRequired" />
                Ship to different address...</td>
        </tr>

    </table>
    <input type="submit" name="newOrder" value="Continue" />
</form>
</div>

<%@ include file="../common/bottom.jsp"%>