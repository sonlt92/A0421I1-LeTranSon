<%--
  Created by IntelliJ IDEA.
  User: Jacky Ryuk
  Date: 10/31/2021
  Time: 12:04
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Calculator</title>
</head>
<body>
<form action="/CalculatorServlet" method="post" onsubmit="return isNum()">
  <p>
    First operand:
    <label>
      <input type="text" name="firstOperand" id="firstOperand">
    </label>
  </p>
  <p>
    Operator:
    <label>
      <select name="operator" id="">
        <option value="+">Addition</option>
        <option value="-">Subtraction</option>
        <option value="*">Multiplication</option>
        <option value="/">division</option>
      </select>
    </label>
  </p>
  <p>
    Second operand:
    <label>
      <input type="text" name="secondOperand" id="secondOperand">
    </label>
  </p>
  <input type="submit" value="Calculator">
</form>
<script>
  function isNum() {
    let checkIsNum = new RegExp("([0-9]+.[0-9]+)|([0-9]+)")
    let firstOperand = document.getElementById("firstOperand").value;
    let secondOperand = document.getElementById("secondOperand").value;
    if (!(firstOperand ==="") && !(secondOperand ==="")){
      if (!checkIsNum.test(firstOperand)) {
        alert("Vui long nhap vao mot so.1");
        return false;
      }
      if (!checkIsNum.test(secondOperand)){
        alert("Vui long nhap vao mot so.2");
        return false;
      }
      return true;
    }else {
      alert("Vui long nhap vao mot so.3");
      return false;
    }
  }
</script>
</body>
</html>
