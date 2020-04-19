$(function () {
    //黑色导航栏点击
    $(".nav_box").each(function (index) { //每个子盒子添加事件
        $(this).on("click", function () {
            console.log();
            $(window).attr('location', $(this).attr('value') + '.html');
        })
    });

    $.ajax({//页面加载成功获取模块所有数据
        type: "get",
        url: "selmeetingbyid",
        dataType: "json",
        success: function (response) {

            for (let i in response) {
                $(".panel-body").append(`<div class="module" task_id=${response[i].Cinvigilateid}></div>`);
                $(".module").eq(i).append(`
             <span class="moduleName pull-right">[更多详情]</span>
                    <br>
                    <br>
                    <span class="task_tile">${response[i].theme}</span>
                    <span class="modulePlace pull-right">地点:${response[i].place}</span>
                    <span class="moduleTime pull-right">时间:${response[i].time}</span>`);
            }
        },
        error: function (xhr) {
            console.log(xhr.responseText);
        },
        complete: function (xhr) {

            // let task_box = `<div class="task_box"></div>`

        }
    });

    $(".head_right").on("click",function () {//点击关闭
        $(".head_right").on("click",function () {//点击关闭
            if(confirm('你确定关闭页面吗')){
                closewin();
            }else{

            }

        });

        function closewin(){
            self.opener=null;
            self.close();
        }

    })

    Mock.mock(
        'http://mockjs', {
            //"userName": "李芳", //模拟名称
            //"age|1-100": 100, //模拟年龄(1-100)
            // "color": "@color", //模拟色值
            "date": "@date('yyyy-MM-dd HH:mm:ss')", //模拟时间
            // "url": "@url()", //模拟url
            "class":"通信173班；通信174班",
            "place":"1401"
            //"content": "今天$conn_string  =  \"host=localhost port=5432 dbname=iadata user=postgres password=slf1739645445\" ;" //模拟文本
        });



    $.ajax({
        url : "http://mockjs",
        async : true,
        type : "GET",
        dataType : "json",
        // 成功后开启模态框
        success : function (data) {
            //$("#txt_exam_subject").val(response.txt_meeting_theme);
            $("#txt_exam_place").val(data.place);
            $("#txt_exam_class").val(data.class);
            $("#txt_exam_time").val(data.date);
           // $("#txt_exam_duration_time").val(data.txt_meeting_desc);
            //$("#txt_exam_invigilator").val(data.);
            //$("#txt_exam_desc").val(data.)
            console.log(response);

        },
        error : function() {
            alert("请求失败");
        }

    });


});