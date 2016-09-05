## Issue
- [How jqGrid custruct a request](http://stackoverflow.com/questions/3527617/get-current-url-including-parameters-of-jqgrid/3530191#3530191)
- [Data Parsing](http://www.trirand.com/jqgridwiki/doku.php?id=wiki:retrieving_data)
- [Options](http://www.trirand.com/jqgridwiki/doku.php?id=wiki:options)



## Example

```
{% extends "page12.jinja2" %}

{% block head_script %}
    <script>
        $.jgrid.defaults.width = 780;
        $.jgrid.defaults.responsive = true;
        $.jgrid.defaults.styleUI = 'Bootstrap';
    </script>
{% endblock %}
{% block content %}
<div">
    <table id="jqGrid" class="table table-striped table-hover table-bordered"></table>
    <div id="jqGridPager"></div>
</div>
    <script type="text/javascript">
        $(document).ready(function () {
            $("#jqGrid").jqGrid({
                url: '/api/user/',
                editurl: '/api/user/',
                postData: {
                    },
                mtype: "GET",
                datatype: "json",
                jsonReader : {
                      root: "rows",
                      page: "page",
                      total: "total",
                      records: "records",
                      repeatitems: true,
                      cell: "cell",
                      id: "id",
                      userdata: "userdata",
                      subgrid: {
                         root:"rows",
                         repeatitems: true,
                         cell:"cell"
                      }
                },
                colNames: ["ID", "Name", "Role", "Email"],
                colModel: [
                    {
                        label: 'ID',
                        name: 'id',
                        width: 40,
                        editable: false,
                        //formatter: "date",
                    },
                    {
                        label : 'Name',
                        name: 'username',
                        width: 100,
                        editable: true,
                        frozen: true,
                        formoptions: {
                            colpos: 1, // the position of the column
                            rowpos: 1, // the position of the row
                            label: "Name: " ,
                            //elmsuffix: " * " // the suffix to show after that
                        }
                    },
                    {
                        label : 'Role',
                        name: 'role',
                        width: 100,
                        editable: true,
                        edittype: "select",
                        editoptions: { value: "admin:admin" },
                        formoptions: {
                            colpos: 1,
                            rowpos: 2
                        }
                    },
                    {
                        label: 'Email',
                        name: 'email',
                        width: 140,
                        editable: true,
                        formoptions: {
                            colpos: 2,
                            rowpos: 1
                        }
                    }
                ],
                // data load setting
                loadOnce : true,
                hiddengrid: false,

                //grid header setting
                hidegrid: true,
                caption: "用户管理",

                hoverrows: false,

                viewrecords: true,
                // table size setting
                //width: 1000,
                autowidth: true,
                height: "auto",

                shrinkToFit: true,


                //search setting
                ignoreCase: true,


                //cellEdit: false,
                footerrow: false,
                gridview: true,

                // grouping settings
                grouping: false,

                //client side sort
                //sortname: "Name",

                //setting params posted to server
                prmNames: {
                    sort: "sidx",
                    order: "order",
                    search: null,
                    nd: null,
                    id: "id",
                    oper:"oper", // operation参数名称
                    editoper:"edit", // 当在edit模式中提交数据时，操作的名称
                    addoper:"add", // 当在add模式中提交数据时，操作的名称
                    deloper:"del", // 当在delete模式中提交数据时，操作的名称
                    subgridid:"id", // 当点击以载入数据到子表时，传递的数据名称
                    npage: null,
                    totalrows: "totalrows" // 表示需从Server得到总共多少行数据的参数名称，参见jqGrid选项中的rowTotal
                    },

                //page button
                pgbuttons: true,

                // dynamic load
//                scroll: false,
//                emptyrecords: 'Scroll to bottom to retrieve new page',

                //subGrid settings
                subGrid: false,

                rownumbers: false,
                multiselect: true,

                // pager settings
                pager: "#jqGridPager",
                toppager: false,
                rowList: [10, 20, 30],
                rowNum: 10,
            });

            $('#jqGrid').navGrid('#jqGridPager',
                { edit: true, add: true, del: true, search: true, refresh: true, cancel: true, view: false, position: "left", cloneToTop: false, },

                // options for the Edit Dialog
                {
                    mtype: "POST",
                    height: 'auto',
                    width: 620,
                    editCaption: "编辑用户",
                    recreateForm: true,
                    closeAfterEdit: true,
                    errorTextFormat: function (data) {
                        return 'Error: ' + data.responseText
                    }
                },
                // options for the Add Dialog
                {
                    mtype: "POST",
                    addCaption: "添加用户",
                    height: 'auto',
                    width: 620,
                    closeAfterAdd: true,
                    recreateForm: true,
                    errorTextFormat: function (data) {
                        return 'Error: ' + data.responseText
                    }
                },
                // options for the Delete Dailog
                {
                     top: 200,
                     left: 200,
                     mtype: "POST",
                     msg: "删除选中的用户?",
                     bSubmit: "删除",
                     bCancel: "取消",
                     caption: "删除用户",
                     reloadAfterSubmit: false,
                     errorTextFormat: function (data) {
                         return 'Error: ' + data.responseText
                     },
                });
        });
        $("#jqGrid").jqGrid('setFrozenColumns');

//     $(window).resize(function () { $('#jqGrid').jqGrid('setGridWidth', parseInt($(window).width()) - 30); });

    </script>
    <script type="text/javascript">
        function getRowID(){
        var myGrid = $('#jqGrid');
        selRowId = myGrid.jqGrid('getGridParam', 'selrow');
        celValue = myGrid.jqGrid('getCell', selRowId, 'id');
        window.id = celValue;
        return celValue;
        };
    </script>
{% endblock %}
```