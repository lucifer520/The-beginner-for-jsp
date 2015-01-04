<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>简单计算器</title>

</head>

<body style="text-align: center;">
    <form action="${pageContext.request.contextPath }/b.jsp"
        method="post">
        <table border="1" width="300px">
            <tr>
                <th colspan="2">简单计算器</th>
            </tr>
            <tr>
                <td>第一个数</td>
                <td><input type="text" name="firstNumber">
                </td>
            </tr>
            <tr>
                <td>第二个数</td>
                <td><input type="text" name="secondNumber">
                </td>
            </tr>
            <tr>
                <td>运算符</td>
                <td><select name="operator">
                        <option value="+">+</option>
                        <option value="-">-</option>
                        <option value="*">*</option>
                        <option value="/">/</option>

                </select>
                </td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="计算">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>