document.forms.level.onsubmit=function(){
   var ztask=this.task.value;
   var zanswerString=this.answerString.value;
   var zvariant1=this.variant1.value;
   var zvariant2=this.variant2.value;
   var zvariant3=this.variant3.value;
   var zvariant4=this.variant4.value;
   var zvariant5=this.variant5.value;
   var zvariant6=this.variant6.value;

$.ajax({
        type: "POST",
        url: " http://localhost:5000/api/QWriteRightAnswer",
        contentType: "application/json",
        dataType: "json",
        data: JSON.stringify({
           task: ztask,
         // task: level.task.value(),
            answerString: zanswerString,
            variant1: zvariant1,
            variant2: zvariant2,
            variant3: zvariant3,
            variant4: zvariant4,
            variant5: zvariant5,
            variant6: zvariant6,
        }),
        success: function(response) {
            console.log(response);
        },
        error: function(response) {
            console.log(response);
        }

});
return false;
};

