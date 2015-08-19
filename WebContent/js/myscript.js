$(document).ready(function(){

});

$(function() {
    /**
    * the element
    */
    var $ui 		= $('#ui_element');

    /**
    * on focus and on click display the dropdown, 
    * and change the arrow image
    */
    $ui.find('.sb_input').bind('focus click',function(){
        $ui.find('.sb_down')
           .addClass('sb_up')
           .removeClass('sb_down')
           .andSelf()
           .find('.sb_dropdown')
           .show();
    });

    /**
    * on mouse leave hide the dropdown, 
    * and change the arrow image
    */
    $ui.bind('mouseleave',function(){
        $ui.find('.sb_up')
           .addClass('sb_down')
           .removeClass('sb_up')
           .andSelf()
           .find('.sb_dropdown')
           .hide();
    });

    /**
    * selecting all checkboxes
    */
    $ui.find('.sb_dropdown').find('label[for="all"]').prev().bind('click',function(){
        $(this).parent().siblings().find(':checkbox').attr('checked',this.checked).attr('disabled',this.checked);
    });
});

/*----login-sign up---*/

$('.form').find('input, textarea').on('keyup blur focus', function (e) {

  var $this = $(this),
      label = $this.prev('label');

      if (e.type === 'keyup') {
            if ($this.val() === '') {
          label.removeClass('active highlight');
        } else {
          label.addClass('active highlight');
        }
    } else if (e.type === 'blur') {
        if( $this.val() === '' ) {
            label.removeClass('active highlight'); 
            } else {
            label.removeClass('highlight');   
            }   
    } else if (e.type === 'focus') {

      if( $this.val() === '' ) {
            label.removeClass('highlight'); 
            } 
      else if( $this.val() !== '' ) {
            label.addClass('highlight');
            }
    }

});

$('.tab a').on('click', function (e) {

  e.preventDefault();

  $(this).parent().addClass('active');
  $(this).parent().siblings().removeClass('active');

  target = $(this).attr('href');

  $('.tab-content > div').not(target).hide();

  $(target).fadeIn(600);

});

/*----/login-sign up-----*/

      
/*---------ui accordion---------*/
    
$('#saved-news').click(function(){
    $('#display-user').load('saved-news.html');
});

$('#user-general').click(function(){
    $('#display-user').load('user-info.html');
});


$('#shared-news').click(function(){
    $('#display-user').load('shared-news.html');
});

$('#commented-news').click(function(){
    $('#display-user').load('commented-news.html');
});

$('#edit-user').click(function(){
    var name = $('#edit-user').parents('tr').children().eq(1).text();
    $('#username').html('<input style="border:1px solid gray" type="text" value="'+name+'"/>');
    $('#edit-user').text("Update");
});



/*--------/ui accordi0n----------*/


