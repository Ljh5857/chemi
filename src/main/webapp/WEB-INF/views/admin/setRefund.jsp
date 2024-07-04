<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Set Refund Data</title>
</head>
<body>
    <h1>Set Refund Data</h1>
    <form action="/admin/setRefund" method="post">
        <div>
            <label for="refundPeriod">Refund Period:</label>
            <select name="refundPeriod" id="refundPeriod">
                <option value="당일">당일</option>
                <option value="1일전">1일전</option>
                <option value="2일전">2일전</option>
                <option value="3~6일전">3~6일전</option>
                <option value="1주이상">1주이상</option>
            </select>
        </div>
        <div>
            <label for="refundPercent">Refund Percent:</label>
            <input type="number" id="refundPercent" name="refundPercent" min="0" max="100" required>
        </div>
        <div>
            <button type="submit">Set Refund</button>
        </div>
    </form>
</body>
</html>
