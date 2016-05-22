/**
 * Created by Анатолий on 12.05.2016.
 */
$(document).ready(function(){


    $("#restaurantstable").DataTable({

        "autoWidth":false,
        "ajax":{
            "url":ajaxAdminUrl+"restaurants",
            "dataSrc":""
        },
        "columns":[
            {"data":"id"},
            {"data":"name"},
            {
                "orderable":false,
                "defaultContent":"",
                "render":renderEditBtn
            },
            {
                "orderable":false,
                "defaultContent":"",
                "render":renderDeleteBtn
            },
            {
                "orderable":false,
                "defaultContent":"",
                "render":function(){
                    return '<a class="btn btn-xs btn-info" ' + '>Lunches</a>';
                }
            }
        ]
        ,
        "initComplete": function(){
            makeEditable("restaurants");
            $("#restaurantstable").find("tbody tr td:last-child a").click(function(){
                var restId=$(this).parents("tr").find("td:first-child").html();

                var lunchesTable = $("#lunchestable");


                    $("#lunchesModal").modal();

                    lunchesTable.DataTable({
                        "bDestroy":true,
                        "ajax":{
                            "url":ajaxAdminUrl+"lunches/"+restId,
                            "type":"GET",
                            "dataSrc":""
                        },
                        "columns":[
                            {"data":"lunch.id"},
                            {"data":"lunch.date"},
                            {"data":"lunch.name"},
                            {"data":"lunch.price"},
                            {"data":"votesCount"},
                            {
                                "orderable":false,
                                "defaultContent":"",
                                "render":function(){
                                    return '<a class="btn btn-xs btn-primary">Edit</a>';
                                }
                            },
                            {
                                "orderable":false,
                                "defaultContent":"",
                                "render":function(){
                                    return '<a class="btn btn-xs btn-danger">Delete</a>'
                                }
                            },
                            {"orderable":false, "defaultContent":""}
                        ],
                        "responsive":{
                            "details":{
                                "renderer":function(api, rowIdx, columns){
                                    var lunchId=columns[0].data;
                                    var table="<table class='table ''><thead><tr>" +
                                        "<td>Id</td>" +
                                        "<td>Name</td>" +
                                        "<td>Description</td>" +
                                        "</tr></thead>" +
                                        "<tbody>";
                                    $.ajax({
                                       "url":ajaxAdminUrl+"lunches/"+lunchId+"/dishes",
                                        "type":"GET",
                                        "async":false,
                                        "success":function(data){
                                            data.forEach(function(item, i, arr){

                                                table+="<tr>" +
                                                "<td>"+item.id+"</td>" +
                                                "<td>"+item.name+"</td>" +
                                                "<td>"+item.description+"</td>" +
                                                "</tr>";

                                            })
                                        }
                                    });
                                    table+="</tbody></table>";
                                    return table;
                                }
                            }
                        }
                    })



            });
            $("#addNewLunch").click(function(){
                $("#lunchForm").slideToggle();
            })
        }

    });


});