<!DOCTYPE html>
<html lang="en" xmlns:v-on="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script type="text/javascript" src="js/vue.min.js"></script>
    <script type="text/javascript" src="js/vue-resource.js"></script>
    <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
</head>
<body>
<div id="app" enctype="multipart/form-data">
    <input type="file" @change="getFile($event)" id="file" name="file"></br>
   <button v-on:click="upload">上传</button>
    <table  border="1">
        <tr  v-for="item in result">
            <td>{{item.name}}</td><td>{{item.phonenum}}</td><td>{{item.address}}</td><td>{{item.productName}}</td><td>{{item.num}}</td>
        </tr>
    </table>
</div>

<script>
    var app=new Vue({
        el: '#app',
        data:{
            result:'' //{"name":'',"phonenum":'',"address":'',"productName":'',"num":''}

        },
        methods: {
            upload: function (event) {
                var excelfile = $("#file").val();
                if(excelfile==''){
                    alert('请上传excel文件!' );
                    return;
                }
                if ((excelfile.indexOf('.xlsx') == -1)) {
                    alert('请上传正确的excel,后缀名为xlsx!');
                    return;
                }
                var exclFormData = new FormData();
                exclFormData.append("filename",this.upath);
                let config = { headers: { 'Content-Type': 'multipart/form-data' } };
                this.$http.post('excel', exclFormData,config).then(function (response) {
                    if(response.ok){
                        response.set
                        this.result=eval(response.bodyText);
                        console.log(this.result);
                        console.log(this.result[0].name);
                    }else{
                        alert("网络出错！")
                        return
                    }

                });
            },
            getFile: function (event) {
                this.upath = event.target.files[0];
            },
        }

    })

</script>
</body>
</html>
