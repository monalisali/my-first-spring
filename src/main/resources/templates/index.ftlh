<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width">
    <title>排行榜</title>
</head>

<body>
   <table>
       <tr>
           <th>排名</th>
           <th>名字</th>
           <th>分数</th>
       </tr>
       <#list rankItems as item>
           <tr>
               <td>${item?index + 1}</td>
               <td>${item.user.name}</td>
               <td>${item.score}</td>
           </tr>
       </#list>

   </table>
</body>

</html>