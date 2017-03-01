/**
 * Created by tangym on 2017/2/17.
 */
$(function () {
    // 将按钮绑定点击事件，查询日志列表
    var columns = [
        {
            field: "id",
            title: "id",
            align: "right",
            sortable: true
        },
        {
            field: "uid",
            title: "用户uid",
            sortable: true
        },
        {
            field: "businessType",
            title: "业务标识",
            sortable: true
        },
        {
            field: "request",
            title: "请求报文",
            sortable: true
        },
        {
            field: "response",
            title: "返回报文",
            sortable: true
        },
        {
            field: "ruleInput",
            title: "规则值",
            sortable: true
        },
        {
            field: "ruleOutput",
            title: "规则结果",
            sortable: true,
        },
        {
            field: "dataChangeLastTime",
            title: "时间",
            sortable: true,
        }
    ];

    $("#btn_search").on('click', function () {
        $.ajax({
            type: 'POST',
            url: "/api/log/search",
            async: true,
            data: {"uid": $("#uid").val(), "start": $("#start").val(), "end": $("#end").val()},
            success: function (data) {
                // 获取数据成功后将表格填充
                var option = {
                    columns: columns,
                    data: data,
                    search: false,
                    searchAlign: 'center',
                    showExport: true,// 显示导出按钮
                    height: 200
                };
                $("#tb_rcloglist").bootstrapTable(option);
            }
        });
    })
})
