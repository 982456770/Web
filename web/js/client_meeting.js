$(function () {
    //黑色导航栏点击
    $(".nav_box").each(function (index) { //每个子盒子添加事件
        $(this).on("click", function () {
            $(window).attr('location', $(this).attr('value') + '.html');
        })
    });
    Mock.mock("getData", {
        "task|2-5":[
            {
                "theme|+1": [
                    "听课",
                    "监考",
                    "考试",
                    "通知"
                ],
                "place|+3": [
                    "America",
                    "France",
                    "China",
                    "Japan"
                ],
                "time": "@date('yyyy-MM-dd HH:mm:ss')",
                "content": "@paragraph()",
                "other": "@url()",
                "meetingid|1-1000": 100
            }
        ]
    })
    $.ajax({
        url: "SelMeeting",
        type: "GET",
        dataType: "json",
        success: function (response) {
            var res = response;
            console.log(response)
            for(let i in res){
                if(res[i].content.length >= 20){
                    res[i].content = res[i].content.slice(1,10)+ "...";
                    res[i].other = res[i].other.slice(1,10)+"...";
                }

                $(".panel-heading").after(`<div class="task" taskId="${res[i].meetingid}"></div>`);
                $(".task:first").append(`<p id="task-theme">${res[i].theme}</p>`);
                $(".task:first").append(`<p id="task-time">${res[i].time}</p>`);
                $(".task:first").append(`<p id="task-place">${res[i].place}</p>`);
                $(".task:first").append(`<p id="task-content">${res[i].content}</p>`);
                $(".task:first").append(`<p id="task-other">${res[i].other}</p>`);
            }

            $(".task").on("click", function(){
                var task = $(this);
                $("#txt_meeting_theme").val(task.children("#task-theme").text());
                $("#txt_meeting_place").val(task.children("#task-place").text());
                $("#txt_meeting_content").val(task.children("#task-content").text());
                $("#txt_meeting_time").val(task.children("#task-time").text());
                $("#txt_meeting_desc").val(task.children("#task-other").text());
                $('#myModal').modal();
            });
        },
        error: function () {
            alert("请求失败");
        }

    });








});