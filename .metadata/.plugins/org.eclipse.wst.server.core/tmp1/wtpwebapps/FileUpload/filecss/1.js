
		var curIndex = 0; 
		var timeInterval = 1000; 
		var arr = new Array(); 
		arr[0] = "1 (1).jpg"; 
		arr[1] = "1 (2).jpg"; 
		arr[2] = "1 (3).jpg"; 
		arr[3] = "1 (4).jpg"; 
		arr[4] = "1 (5).jpg"; 
		arr[5] = "1 (6).jpg"; 
		arr[6] = "1 (7).jpg"; 
		arr[7] = "1 (8).jpg";
		setInterval(changeImg,timeInterval); 
		function changeImg() { 
			var obj = document.getElementById("obj"); 
			if (curIndex == arr.length-1) { 
				curIndex = 0; 
			} else { 
				curIndex += 1; 
			  } 
			obj.src = arr[curIndex]; 
		} 

		

		setInterval(test,timeInterval); 
		var array = new Array(); 
		var index = 0; 
		var array = new Array("1 (1).jpg","1 (2).jpg","1 (3).jpg","1 (4).jpg","1 (5).jpg","1 (6).jpg","1 (7).jpg","1 (8).jpg"); 
		function test() { 
			var myimg=document.getElementById("imgs"); 
			if(index==array.length-1) 
			{ index=0; }else{ index++; } 
			myimg.src=array[index]; 
		} 
