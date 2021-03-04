
//var billsContainer = document.getElementById('center');
var billsContainer=document.createElement('div')
//billsContainer=document.getElementsByClassName("center");

var cartBillsList = [];
var billsList = [];
var billDetails;

window.onload = initialize;

var Bill = function(id, company,  accountNumber, amount, billType,Service,billDate, dueDate,description ){
	this.id = id;
	this.company = company;
	this.accountNumber = accountNumber; 
	this.amount = amount; 
	this.billType = billType; 
	this.Service = Service; 
	this.billDate = billDate; 
	this.dueDate = dueDate; 
	this.description=description;
	
}

function initialize(){ 
	var bill = createBill();  // return bill

	// showBill(bill);
	
	billsList = createBillsList();
	showAllBills(billsList);  // billsList Array
	
//	showAllBills(cartBillsList);  //  cartBillsList Array
}

function createBill(){
	var bill = new Bill(1, "ConEdison",  123456321, "$ 90", "Utility","Elictricity","07/30/2020", "08/20/2020","Description");
	// more business logic
	return bill;
}

function showBill(bill, billsContainer, billsList ){

	// Div container for each bill
	const billContainer = document.createElement('div');
//	billContainer.style.background-color='grey';
//	billContainer.style.display='flex';
//	billContainer.style.flex-wrap='nowrap';

	billsContainer.appendChild(billContainer);
	
	// Show the bill properties and values
	for(p in bill){
		if (p == 'company' || p =='amount' || p =='dueDate' || p =='billDate'){
			//const billElement = document.createElement('p');

		//	billElement.textContent = bill[p];
		//	billContainer.appendChild(billElement);

			const billElement = document.createElement('p');
			billElement.style.float='left';
			//billElement.style.text-align='center';
			billElement.style.margin='1% 1%';
			billElement.textContent = p+":"+ bill[p];
			billContainer.appendChild(billElement);
		}  

	} // for loop
	

	
	const btnAdd = document.createElement('button');
	btnAdd.addEventListener('click',function() {viewBillDetails(bill)});
	btnAdd.innerHTML = 'view bill details';
	billContainer.appendChild(btnAdd);
	const btnRemove = document.createElement('button');
	btnRemove.addEventListener('click',function() {RemoveFromBillsList(bill, billsList)});
	btnRemove.innerHTML = 'Remove';
	billContainer.appendChild(btnRemove);
	
	

	const hr = document.createElement('hr');
	billContainer.appendChild(hr);
} // function showBill

function createBillsList(){
	var billsList = [];
	
	for (var i=0;i<=11;i++){
		var bill = createBill();
		billsList.push(bill);
	}
	return billsList;	
}

// Show all bills from the billsList
function showAllBills(billsList){
	
	
	// billsContainer.innerHTML = " ";
	
	// Div container for all bills
//	const billsContainer = document.createElement('div');
	document.getElementById('center').appendChild(billsContainer);
	
	billsList.forEach(bill => showBill(bill, billsContainer, billsList) );
}

function viewBillDetails(bill){
	

/*	for(p in bill){
		billsContainer = document.getElementById('center');
			//const billElement = document.createElement('p');

		//	billElement.textContent = bill[p];
		//	billContainer.appendChild(billElement);

			const billElement = document.createElement('p');
			//billElement.style.float='left';
			//billElement.style.text-align='center';
			//billElement.style.margin='1% 1%';
			billElement.textContent = bill[p];
			billContainer.appendChild(billElement);
			document.getElementById('center').appendChild(billContainer);

		  

	}
*/
}

function RemoveFromBillsList(bill, billsList){
	// here ???
	// 1. find the index of bill in the billsList array indexOf(bill)	
	var index = billsList.indexOf(bill);
	// 2. remove the element from the BillList Array using splice(index,1)
	billsList.splice(index,1);
	
	// const billsContainer = document.createElement('div');
	
	billsContainer.remove();
	billsContainer = document.createElement('div');
	//billsContainer = document.getElementById('center');
	showAllBills(billsList);
	

}