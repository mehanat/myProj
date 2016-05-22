/**
 * Created by Анатолий on 12.05.2016.
 */
var form;
var ajaxAdminUrl="/admin/ajax/";

function makeEditable(entity){
    form=$("#detailsForm");

    ajaxAdminUrl+=entity+"/";

    form.submit(function(){
        save()
    })
}

function add() {
    form.find(":input").val("");
    $('#id').val(0);
    $('#editRow').modal();
}

function updateRow(id){
    $.ajax({
        "url":ajaxAdminUrl+id,
        "success":function(data){
            $.each(data, function(key, value){
                    form.find("input[name='" + key + "']").val(
                        value
                    );

            });
            $('#editRow').modal();
        }
    });
}

function deleteRow(id){
    $.ajax({
        "url":ajaxAdminUrl+id,
        "type":"DELETE",
        "success":function(){

        }
    })
}

function renderEditBtn(data, type, row) {
    if (type == 'display') {
        return '<a class="btn btn-xs btn-primary" onclick="updateRow(' + row.id + ');">Edit</a>';
    }
    return data;
}

function renderDeleteBtn(data, type, row) {
    if (type == 'display') {
        return '<a class="btn btn-xs btn-danger" onclick="deleteRow(' + row.id + ');">Delete</a>';
    }
    return data;
}

function save(){
    $.ajax({
        "url":ajaxAdminUrl,
        "type":"POST",
        "data":form.serialize(),
        "success":function(){
            $('#editRow').modal("hide");
        }
    })
}