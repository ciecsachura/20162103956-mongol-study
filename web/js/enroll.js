// JavaScript Document
var tempm = 1;
var Actemp = 1;
var srchtemp = 1;
function show_menuM() {
    if (tempm === 1) {
        document.getElementById('menu_box').style.display = 'block';
        document.getElementById('menu_on').style.background = 'url(/Images/mgl_menu_off.png) no-repeat';
        tempm = 0;
        document.getElementById('indexpic_box').style.display = 'none';
        Actemp = 1;
        document.getElementById('Search_box').style.display = 'none';
        srchtemp = 1;
    } else {
        document.getElementById('menu_box').style.display = 'none';
        document.getElementById('menu_on').style.background = 'url(/Images/mgl_menu.png) no-repeat';
        tempm = 1;
    }
}
function show_indexpicM() {
    if (Actemp === 1) {
        document.getElementById('indexpic_box').style.display = 'block';
        Actemp = 0;
        document.getElementById('menu_box').style.display = 'none';
        document.getElementById('menu_on').style.background = 'url(/Images/mgl_menu.png) no-repeat';
        tempm = 1;
        document.getElementById('Search_box').style.display = 'none';
        srchtemp = 1;
    } else {
        document.getElementById('indexpic_box').style.display = 'none';
        Actemp = 1;
    }
}
function openWin(tag, obj) {
    window.location = "" + tag;
}

var Commtemp = 1;
function Comm_Writer() {
    if (Commtemp === 1) {
        document.getElementById('Comment_Form').style.display = 'block';
        Commtemp = 0;
    } else {
        document.getElementById('Comment_Form').style.display = 'none';
        Commtemp = 1;
    }
}

var keyboard_help = 1;
function keyboard_help_box() {
    if (keyboard_help === 1) {
        document.getElementById('keyboard_help_div').style.display = 'block';
        keyboard_help = 0;
    } else {
        document.getElementById('keyboard_help_div').style.display = 'none';
        keyboard_help = 1;
    }
}