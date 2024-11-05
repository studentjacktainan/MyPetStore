<%@ include file="../common/top.jsp"%>
<div id="Catalog">
    <form method="post" action="register">

    <h3>User Information</h3>

    <table>
        <tr>
            <td>User ID:</td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td>New password:</td>
            <td><input type="text" name="password"></td>
        </tr>
        <tr>
            <td>Repeat password:</td>
            <td><input type="text" name="repeatedPassword"></td>
        </tr>
    </table>
        <h3>Account Information</h3>

        <table>
            <tr>
                <td>First name:</td>
                <td><input type="text" name="firstname"></td>
            </tr>
            <tr>
                <td>Last name:</td>
                <td><input type="text" name="lastname"></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><input type="text" name="email" size="40"></td>

            </tr>
            <tr>
                <td>Phone:</td>
                <td><input type="text" name="phone"></td>
            </tr>
            <tr>
                <td>Address 1:</td>
                <td><input type="text" size="40"name="address1"></td>
            </tr>
            <tr>
                <td>Address 2:</td>
                <td><input type="text" size="40"name="address2"></td>
            </tr>
            <tr>
                <td>City:</td>
                <td><input type="text" name="city"></td>
            </tr>
            <tr>
                <td>State:</td>
                <td><input type="text" size="4" name="state"></td>
            </tr>
            <tr>
                <td>Zip:</td>
                <td><input type="text" size="10" name="zip"></td>
            </tr>
            <tr>
                <td>Country:</td>
                <td><input type="text" name="country" size="15"></td>
            </tr>
        </table>

        <h3>Profile Information</h3>

        <table>
            <tr>
                <td>Language Preference:</td>
                <td>
                    <select name="languagePreference" id="languagePreference">
                        <c:forEach var="languages" items="${sessionScope.languages}">
                            <option>${languages}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Favourite Category:</td>
                <td>
                    <select name="favouriteCategory" id="favouriteCategory">
                        <c:forEach var="categories" items="${sessionScope.categories}">
                            <option>${categories}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Enable MyList</td>
                <td><input type="checkbox" name="enableMylist"></td>
            </tr>
            <tr>
                <td>Enable MyBanner</td>
                <td><input type="checkbox" name="enableBanner"></td>
            </tr>
        </table>
        <br/>
        <c:if test="${requestScope.signOnMsg != null}">
            <p><font color="red">${requestScope.signOnMsg}</font></p>
        </c:if>
        Verification Code : <input  type="text" name="checkCode"/><br/>
        <img id="imagecode" src="<%= request.getContextPath()%>/imageServlet"/><br/>
        <input type="submit" name="newAccount" value="Save Account Information">
    </form>
</div>
<%@ include file="../common/bottom.jsp"%>

