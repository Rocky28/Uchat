var req;
var isIE;
var completeField;
var completeTable;
var autoRow;

function init()
{
    var cinterval;
            function countdown_timer() {
        var eventSource = new EventSource('checkfornewmsg');
        eventSource.addEventListener('refresh', function (event) {
            if (event.data == 'yes') {
                /*document.getElementById('newframe').contentWindow.location.reload();*/
                doCompletion();
            }
        }, false);
    }
    cinterval = setInterval(countdown_timer, 1000);
    completeField = document.getElementById("senderemailcurrect");
    completeTable = document.getElementById("complete-table");
    autoRow = document.getElementById("auto-row");
    completeTable.style.top = getElementY(autoRow) + "px";
}

function doCompletion() {
        var url = "allchats?action=complete&id=1";
        req = initRequest();
        req.open("GET", url, true);
        req.onreadystatechange = callback;
        req.send(null);
}

function initRequest() {
    if (window.XMLHttpRequest) {
        if (navigator.userAgent.indexOf('MSIE') != -1) {
            isIE = true;
        }
        return new XMLHttpRequest();
    } else if (window.ActiveXObject) {
        isIE = true;
        return new ActiveXObject("Microsoft.XMLHTTP");
    }
}
function callback() {
    
   clearTable();
    if (req.readyState == 4) {
        if (req.status == 200) {
            parseMessages(req.responseXML);
        }
    }
}

function parseMessages(responseXML) {

    // no matches returned
    if (responseXML == null) {
        return false;
    } else {

        var composers = responseXML.getElementsByTagName("composers")[0];
            
        if (composers.childNodes.length > 0) 
        {
            
            // completeTable.setAttribute("bordercolor", "black");
            //completeTable.setAttribute("border", "1");
            completeTable.setAttribute("font-color", "black")
            completeTable.setAttribute("font-size", "5px")
            for (loop = 0; loop < composers.childNodes.length; loop++) 
            {
                var composer = composers.childNodes[loop];
                var senderemail = composer.getElementsByTagName("senderemail")[0];
                var recieveremail = composer.getElementsByTagName("recieveremail")[0];
                var msg = composer.getElementsByTagName("msg")[0];
                var dnt = composer.getElementsByTagName("dnt")[0];
                var requester = composer.getElementsByTagName("requester")[0];
                appendComposer(requester.childNodes[0].nodeValue,senderemail.childNodes[0].nodeValue,recieveremail.childNodes[0].nodeValue,msg.childNodes[0].nodeValue,dnt.childNodes[0].nodeValue);
                //appendComposer(senderemail,recieveremail,msg,dnt);
            }   
        }
    }
}

function appendComposer(requester,senderemail,recieveremail,msg,dnt) {

    var row, row1;
    var cell, cell1;
    var linkElement, linkElement1;

    if (isIE) {
        completeTable.style.display = 'block';
        row = completeTable.insertRow(completeTable.rows.length);
        cell = row.insertCell(0);
        row1 = completeTable.insertRow(completeTable.rows.length);
        cell1 = row.insertCell(0);
    } else {
        completeTable.style.display = 'table';
        row = document.createElement("tr");
        cell = document.createElement("td");
        row.appendChild(cell);
        completeTable.appendChild(row);
        row1 = document.createElement("tr");
        cell1 = document.createElement("td");
        row1.appendChild(cell1);
        completeTable.appendChild(row1);
        if(senderemail==requester)
        {
            cell.setAttribute("id","mysyd");
            cell1.setAttribute("id","mysyd");
        }
        else
        {
            cell.setAttribute("id","odrsyd");
            cell1.setAttribute("id","odrsyd");
        }
    }

    cell.className = "popupCell";
    cell1.className = "popuoCell";
    linkElement = document.createElement("p");
    linkElement.className = "popupItem";
    //linkElement.setAttribute("href", "allchats?action=lookup&id=1");
    linkElement.appendChild(document.createTextNode(/*senderemail + " " + recieveremail + " " +*/ msg + "\n"));
    linkElement1 = document.createElement("p");
    linkElement1.className = "popupItem";
    linkElement1.appendChild(document.createTextNode(/*senderemail + " " + recieveremail + " " +*/ "\n" + dnt));
    cell.appendChild(linkElement);
    cell1.appendChild(linkElement1);
}

function getElementY(element){

    var targetTop = 0;

    if (element.offsetParent) {
        while (element.offsetParent) {
            targetTop += element.offsetTop;
            element = element.offsetParent;
        }
    } else if (element.y) {
        targetTop += element.y;
    }
    return targetTop;
}

function clearTable() {
    if (completeTable.getElementsByTagName("tr").length > 0) {
        completeTable.style.display = 'none';
        for (loop = completeTable.childNodes.length -1; loop >= 0 ; loop--) {
            completeTable.removeChild(completeTable.childNodes[loop]);
        }
    }
}   