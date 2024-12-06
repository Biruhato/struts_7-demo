$(function() {
	// 格式"funcNm-funcAction.action",例:測試-sample.action
	var functionUrlArray = new Array("首頁-index.action", "Func範例-sample.action");

	// 注意!此兩行有先後順序
	$("#menuPosi").html(menuProduce(functionUrlArray, "menu"));
	// 如果JSP上有<div id="#menuPosi"></div>區域的話,此行會執行並取代該區域
	$("#menu").menu();// 針對menuProduce()內所指定的id,啟動jQuery的menu API
});

/**
 * 移除字串中最後一個符號字串
 */
function removeLastSymbol(str, symbol) {
	var listIndex = str.lastIndexOf(symbol);
	return str.substring(0, listIndex);
}

/**
 * 將內容的br轉\r\n
 */
function contents_htmlWrapSymbol_2_textWrapSymbol(contents) {
	var res = null;
	var contentsArray = contents.split("<br>");

	for (var i = 0; i < contentsArray.length; i++) {
		if (res == null) {
			res = contentsArray[i] + "\r\n";
		} else {
			res += contentsArray[i] + "\r\n";
		}
	}

	return res;
}

/**
 * 功能選單產生器(for jQuery的menu API)
 */
function menuProduce(functionUrlArray, menuIdNm) {
	var temp = null;

	for (var i = 0; i < functionUrlArray.length; i++) {
		var nmAndUrl = functionUrlArray[i].split("-");

		var nm = nmAndUrl[0];
		var url = nmAndUrl[1];

		if (temp == null) {
			temp = "<li><a href='" + url + "'>" + nm + "</a></li>";
		} else {
			temp += "<li><a href='" + url + "'>" + nm + "</a></li>";
		}
	}

	var s = "<ul id='" + menuIdNm + "'>" + temp + "</ul>";

	return s;
}

/**
 * 確認bList裡所有的boolean為true
 * 
 * @param bArray
 * @returns {Boolean}
 */
function checkAArrayIsAllTrue(bArray) {
	var b = true;

	for (var i = 0; i < bArray.length; i++) {
		if (bArray[i] == false) {
			b = false;
		}
	}

	return b;
}

/**
 * 確認bList裡所有的boolean為true Type2
 * 
 * @param bArray
 * @returns {Boolean}
 */
function checkBArrayIsAllTrueType2(bArray) {
	var resB = false;
	// var arrayValue = bArray.length;
	var count = 0;

	for (var i = 0; i < bArray.length; i++) {
		if (bArray[i] == true) {
			count++;
		}
	}

	if (arraValue == count) {
		resB = true;
	}

	return resB;
}

/**
 * 確認text裡是否有"均含"symbolArray的所有的字
 */
function checkTextHaveAllUnlegalSymbol() {
	// 未寫,不知道有沒有這類需求
}

/**
 * 確認text裡是否有含symbolArray的其中一個字
 */
function checkTextHaveOneOfSymbolListType2(text, symbolArray) {
	var b = false;

	for (var i = 0; i < symbolArray.length; i++) {
		if (str_contains(text, symbolArray[i])) {
			b = true;
		}
	}

	return b;
}

/**
 * 確認text裡是否有含symbolArray的其中一個字(使用一個一個字檢查標準表示式<--似乎不需要,已被Type2取代)
 * 
 * @param text
 *            欲檢查字
 * @param symbolArray
 *            檢核的符號或字
 */
function checkTextHaveOneOfSymbolList(text, symbolArray) {
	var bList = new Array();
	var b = false;
	var count = 0;

	for (var i = 0; i < text.length; i++) {
		for (var j = 0; j < symbolArray.length; j++) {
			bList[count] = checkRegular(text[i], symbolArray[j]);
			count++;
		}
	}

	for (var i = 0; i < bList.length; i++) {
		if (bList[i] == true) {
			b = true;
		}
	}

	return b;
}

/**
 * 確認陣列中所有的String是否含有不合法的符號(或許可以將html標籤都弄進來,"'"jQuery的$.post()似乎會自動截斷)
 */
function check_StrArray_ContainUnlegalSymbol(strArray) {
	var b = false;
	var bList = new Array();
	var unlegalSymbolArray = new Array("'", "<", ">");

	for (var i = 0; i < strArray.length; i++) {
		bList[i] = checkTextHaveOneOfSymbolListType2(strArray[i],
			unlegalSymbolArray);
	}

	for (var i = 0; i < bList.length; i++) {
		if (bList[i] == true) {
			b = true;
		}
	}

	return b;
}

/**
 * 輸入select id,自動產生月份,html語法例:<select name="sel" id="sel"></select>(不知道有沒有必要留在commons)
 * 
 * @param id
 */
function genOptionMonth(id) {
	$(id).append("<option></option>");

	for (var i = 1; i <= 12; i++) {
		if (i < 10) {
			$(id).append(
				"<option vlaue=" + "0=" + i + "=>" + "0" + i + "</option>");
		} else {
			$(id).append("<option vlaue=" + i + ">" + i + "</option>");
		}
	}
}

/**
 * 如果select標籤和hidden input標籤在同一個td內,則使用hidden input的值來set select的值
 * 
 * 假設html為<table>
 * <tr>
 * <td><input type="hidden" value="test"> <select name="sel" id="sel"><option
 * value="test">test</option></select></td>
 * </tr>
 * </table>
 * 
 * 使用setSelectOptionByTdHidden("#sel")會找td中的value來set select的值
 */
function setSelectOptionByTdHidden(id) {
	var optionList = $(id).find("option");
	var hiddenVal = $(id).closest("td").find("input[type=hidden]").val();

	for (var j = 0; j < optionList.length; j++) {
		if (optionList.eq(j).val() == hiddenVal) {
			optionList.eq(j).prop("selected", true);
		}
	}
}

/**
 * 將不合法的符號覆蓋(因為Javascript的replace()似乎僅碰到第一個符號就停止了,故這邊強制循環檢查直到沒有符號為止)
 * 
 * @param text
 * @returns
 */
function replaceUnlegalSymbol(text) {
	var unlegalSymbolArray = new Array("'", "<", ">");
	var legalSymbolArray = new Array("’", "＜", "＞");

	while (containsCheckByArray(text, unlegalSymbolArray)) {
		for (var i = 0; i < unlegalSymbolArray.length; i++) {
			text = text.replace(unlegalSymbolArray[i], legalSymbolArray[i]);
		}
	}

	return text;
}

/**
 * 檢查字串是否包含字串陣列其中一個字
 * 
 * @param str
 * @param array
 * @returns {Boolean}
 */
function containsCheckByArray(str, array) {
	var b = false;

	for (var i = 0; i < array.length; i++) {
		if (str_contains(str, array[i])) {
			b = true;
		}
	}

	return b;
}

/**
 * 檢查字串是否包含另外一個字串
 * 
 * @param checkStr
 * @param Str
 */
function str_contains(checkStr, str) {
	var b = false;

	if (checkStr.indexOf(str) != -1) {
		b = true;
	}

	return b;
}

/**
 * 標準表示式檢核
 * 
 * @param beCheckStr
 * @param regularExpStr
 * @returns {Boolean}
 */
function checkRegular(beCheckStr, regularExpStr) {
	var b = false;
	var re = new RegExp("[" + regularExpStr + "]");

	if (beCheckStr.match(re)) {
		b = true;
	}

	return b;
}

/**
 * 標準表示式確認(此範例為每個字為數字,並且不能為英文)
 * 
 * @param str
 */
function checkStringIsNumWithRegularExp(str) {
	var arrayBoolean = new Array(str.length);

	for (var i = 0; i < str.length; i++) {
		if (i < str.length) {
			var s2 = str.substring(i, i + 1);

			var regular = new RegExp("[0-9]");
			var regular2 = new RegExp("[^A-Za-z]");

			if (s2.match(regular) & s2.match(regular2)) {
				arrayBoolean[i] = true;
			} else {
				arrayBoolean[i] = false;
			}
		}
	}

	return checkBArrayIsAllTrue(arrayBoolean);
}

/**
 * 確認boolean array裡面是否都是true
 * 
 * @param arrayBoolean
 * @returns {Boolean}
 */
function checkBArrayIsAllTrue(arrayBoolean) {
	var b = true;

	for (var i = 0; i < arrayBoolean.length; i++) {
		if (arrayBoolean[i] == false) {
			b = false;
		}
	}

	return b;
}

function chineseNumberType2() {

}

/**
 * @param number
 *            任意羅馬數字
 * @param lowerorsupper
 *            "upper":零壹貳參肆伍陸柒捌玖,"lower":〇一二三四五六七八九
 * @param tail
 * @returns
 */
function chineseNumber(number, lowerorsupper, tail) {
	// 轉換值是否為整數
	if (!isNaN(parseInt(number * 1))) {
		// --------------
		// 定義變數
		// --------------
		// 小寫的中文數字
		var chineseNumber_lower = ('〇一二三四五六七八九').split('');
		// 大寫的中文數字
		var chineseNumber_upper = ('零壹貳參肆伍陸柒捌玖').split('');
		// 數詞單位陣列
		var chineseOrder = ('十百千元萬億兆京垓秭穰溝澗正載').split('');

		if (tail == null) {
			chineseOrder[3] = '元整';
		} else {
			chineseOrder[3] = tail;
		}

		// 定義儲存轉換後的數字結果陣列
		var transformNumber = new Array();
		// 逆轉數字後的數字陣列
		var numberAsString = new Array();
		// 用來記錄移動位數的索引(從tail開始)
		var orderFlag = 3;
		// --------------
		// 數字處理
		// --------------
		// 將數字字串化
		number = number + '';

		// 逆轉數字後儲入陣列
		for (var i = number.length - 1; i >= 0; i--) {
			numberAsString[numberAsString.length++] = number.charAt(i);
		}

		// 針對每個英文數字處理
		for (var i = 0; i < numberAsString.length; i++) {
			// 產生對應的中文數字，並且依大小寫有所不同
			if (lowerorsupper == 'upper') {
				numberAsString[i] = chineseNumber_upper[numberAsString[i]];
				chineseOrder[0] = '拾';
				chineseOrder[1] = '佰';
				chineseOrder[2] = '仟';
			} else {
				numberAsString[i] = chineseNumber_lower[numberAsString[i]];
				chineseOrder[0] = '十';
				chineseOrder[1] = '百';
				chineseOrder[2] = '千';
			}

			// 添加數詞
			switch ((i + 1) % 4) {
				case 1:
					transformNumber[numberAsString.length - i] = numberAsString[i]
						+ chineseOrder[orderFlag];
					break;
				case 2:
					transformNumber[numberAsString.length - i] = numberAsString[i]
						+ chineseOrder[0];
					break;
				case 3:
					transformNumber[numberAsString.length - i] = numberAsString[i]
						+ chineseOrder[1];
					break;
				case 0:
					transformNumber[numberAsString.length - i] = numberAsString[i]
						+ chineseOrder[2];
					break;
			}

			// 每處理四個數字後移動位數索引
			if ((i + 1) % 4 == 0) {
				orderFlag++;
			}
		}

		// 回傳轉換後的中文數字
		return transformNumber.join('');
	} else {
		return '數字必需為整數';
	}
}