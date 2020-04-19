/**
 * 1.点击创建新的任务
 * 2.页面加载成功，添加任务盒子
 * 2.1 所有的盒子事件行为
 * 2.2 改变黄色圆圈数字
 * 
 * 3.点击我创建的项目时，刷新当前页面
 * 4.点击进行中的项目
 * 5.点击已完成的项目
 * 6.模态框点击提交保存
 * 7.根据返回的数据判断是否生成页码
 */
$(function () {

    var peopleArr = [];
    //黑色导航栏点击
    $(".nav_box").each(function (index) { //每个子盒子添加事件
        $(this).on("click", function () {
            console.log();
            $(window).attr('location', $(this).attr('value') + '.html');
        })
    });

    $(".subnav>div").hover(function () { //鼠标移入div，设置字体图标变色
            $(this).find("i").addClass("i_hover");
        },
        function () {
            $(this).find("i").removeClass("i_hover");
        }
    );

    $.ajax({ //页面加载成功，获取当前模块的所有数据
        type: "get",
        url: "",
        dataType: "json",
        success: function (response) {

            for (let i in response) {
                $(".nav_content>.content").append(`<div class="task_box" task_id=${response[i].meetingid}></div>`);
                $(".task_box").eq(i).append(`<div class="prompt">
                 <span></span>
                 <button type="button" class="btn btn-default delete">删除任务</button>
                 <button type="button" class="btn btn-default detail">查看详情</button>
             </div>
             <i class="iconfont" title="查看更多">&#xe64c;</i>
             <p class="task_title">${response[i].theme}</p>
             <p class="task_box_des">${response[i].time}</p>
             <p class="task_box_des">地点：${response[i].place}</p>`);
            }
            $(".head>span").html(response.length);

            $(".task_box i").on("click", function (ev) { //点击更多按钮显示prompt框
                let $box = $(this).parent();
                let $box_i = $(this);
                let x = $box_i.offset().left;
                let y = $box_i.offset().top;
                let $prompt_status = $box.children(".prompt").css("display");
                // console.log($(".prompt").children("button"))

                if ($prompt_status == "none") { //设置prompt位置
                    $box.children(".prompt").css({
                        "display": "block"
                    });
                }

                $(".task_box>i").mouseleave(function () { //鼠标移出prompt框500ms后隐藏
                    timer = setTimeout(function () {
                        $(".prompt").css("display", "none");
                    }, 300);
                    $(".prompt").mouseenter(function () {
                        clearTimeout(timer);
                    })
                    $(".prompt").mouseleave(function () {
                        clearTimeout(timer);
                        timer = setTimeout(function () {
                            $(".prompt").css("display", "none");
                        }, 300);
                    });
                    clearTimeout(timer)
                });
            });

            $(".prompt").children(".delete").on("click", function () { // 删除任务按钮
                // $(this).unbind("click");
                let confm = confirm("您确定删除这个任务吗？");

                if (confm == true) {
                    let delete_task_id = $(this).parents(".task_box").attr("task_id");
                    let $box = $(this).parents(".task_box");

                    $.ajax({
                        type: "post",
                        url: "",
                        data: {
                            "task_id": delete_task_id
                        },
                        dataType: "json",
                        success: function (response) {
                            $box.remove();
                        },
                        error: function (xhr) {
                            console.log(xhr.responseText);
                        }
                    });
                } else {

                    return;
                }
            });

        },
        error: function (xhr) {
            console.log(xhr.responseText);
        }
    });

    $(".subnav_1").on("click", function () { //我创建的项目
        window.location.reload(); // 刷新当前页面
        
    });


    $(".subnav_2").on("click", function () { //进行中的项目
        $.ajax({
            type: "GET",
            dataType: "json",
            url: "",
            data: "data",
            success: function (response) {
                $(".nav_content>.content").empty();

                for (let i = 0; i < response.length; i++) {
                    $(".nav_content>.content").append(`<div class="task_box" task_id=${response[i].meetingid}></div>`);
                    $(".task_box").eq(i).append(`<div class="prompt">
                    <span></span>
                    <button type="button" class="btn btn-default delete">删除任务</button>
                    <button type="button" class="btn btn-default detail">查看详情</button>
                </div>
                <i class="iconfont" title="查看更多">&#xe64c;</i>
                <p class="task_title">${response[i].theme}</p>
                <p class="task_box_des">${response[i].time}</p>
                <p class="task_box_des">地点：${response[i].place}</p>`);
                }
            },
            error: function (xhr) {
                console.log(xhr.responseText);
            },
            complete: function () {

            }
        });
    });

    $(".subnav_3").on("click", function () { //已完成的项目
        $.ajax({
            type: "GET",
            dataType: "json",
            url: "",
            data: "data",
            success: function (response) {
                $(".nav_content>.content").empty();
                console.log(response);
                for (let i = 0; i < response.length; i++) {
                    $(".nav_content>.content").append(`<div class="task_box" task_id=${response[i].meetingid}></div>`);
                    $(".task_box").eq(i).append(`<div class="prompt">
                    <span></span>
                    <button type="button" class="btn btn-default delete">删除任务</button>
                    <button type="button" class="btn btn-default detail">查看详情</button>
                </div>
                <i class="iconfont" title="查看更多">&#xe64c;</i>
                <p class="task_title">${response[i].theme}</p>
                <p class="task_box_des">${response[i].time}</p>
                <p class="task_box_des">地点：${response[i].place}</p>`);
                }
            },
            error: function (xhr) {
                console.log(xhr.responseText);
            },
            complete: function () {

            }
        });
    });
    $(".task_box_one").on("click", function () { //创建新的任务
        $('#myModal').modal();

        $.ajax({    //获取模态框下拉列表人员
            type: "GET",
            dataType: "json",
            url: "SendName",

            success: function (response) {
                $("#contacts").empty();

                for (let i in response) {
                    $("#contacts").append(`<li id=${response[i].id}><a href="#">${response[i].name}</a></li>`);
                }
                $("#contacts>li").on("click", function () {
                    var inputString = $("#txt_meeting_participants").val();
                    var name = $(this).text();
                    var id = $(this).attr("id");
                    var arr = {
                        "nane": name,
                        "id": id
                    }
                    
                    peopleArr.push(arr);
                    inputString += $(this).text() + ",";
                    $("#txt_meeting_participants").val(inputString);

                })
            },
            error: function (xhr) {
                console.log(xhr.responseText);
            }
            
        });
    });

    $("#btn_submit").on("click", function () { //提交保存
        var data = {
            "theme": $("#txt_notice_theme").val(),
            "place": $("#txt_notice_place").val(),
            "people": peopleArr,
            "content": $("#txt_notice_content").val(),
            "time": $("#txt_notice_time").val(),
            "other": $("#txt_notice_desc").val(),
            "length": peopleArr.length
        }
        console.log(data);

        $.ajax({
            type: "POST",
            dataType: "text",
            url: "",
            data: data,
            success: function (response) {
                alert("提交成功！");
                console.log(data);
                $("#myModal input").val("");
                window.location.reload();
            },
            error: function (xhr) {
                alert("提交失败，请重新提交")
                console.log(xhr.responseText);
            },
            complete: function () {
                peopleArr = [];
            }
        });
    });

});