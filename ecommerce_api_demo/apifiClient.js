let apiUrl = location.origin + '/graphql';
let bearerToken = undefined;

export default{

	setBearerToken(token){
		bearerToken = token;
	},

	setApiUrl(url){
		apiUrl = url;
	},

	async associateProductsWithShoppingCart(owner, input, expectedReturn, customHeaders){
			let requestHeaders = { "Content-Type": "application/json" }
			if(customHeaders !== undefined) requestHeaders = Object.assign({}, requestHeaders, customHeaders);
			if(bearerToken !== undefined) requestHeaders["Authorization"] = bearerToken;
			let opts = {
				method: "POST",
				credentials: "include",
				headers: requestHeaders,
				body: JSON.stringify({
					query: `mutation associateProductsWithShoppingCart($owner: ShoppingCartInput, $input: [ProductInput]) { associateProductsWithShoppingCart(owner: $owner, input: $input)${expectedReturn} }`, 
					variables: {
						"owner": owner, 
						"input": input
					}, 
					operationName: "associateProductsWithShoppingCart"
				})
			};
			return await (await fetch(apiUrl, opts)).json();
	},

	async removeProductsFromShoppingCart(owner, input, expectedReturn, customHeaders){
			let requestHeaders = { "Content-Type": "application/json" }
			if(customHeaders !== undefined) requestHeaders = Object.assign({}, requestHeaders, customHeaders);
			if(bearerToken !== undefined) requestHeaders["Authorization"] = bearerToken;
			let opts = {
				method: "POST",
				credentials: "include",
				headers: requestHeaders,
				body: JSON.stringify({
					query: `mutation removeProductsFromShoppingCart($owner: ShoppingCartInput, $input: [ProductInput]) { removeProductsFromShoppingCart(owner: $owner, input: $input)${expectedReturn} }`, 
					variables: {
						"owner": owner, 
						"input": input
					}, 
					operationName: "removeProductsFromShoppingCart"
				})
			};
			return await (await fetch(apiUrl, opts)).json();
	},

	async getCustomerById(input, expectedReturn, customHeaders){
			let requestHeaders = { "Content-Type": "application/json" }
			if(customHeaders !== undefined) requestHeaders = Object.assign({}, requestHeaders, customHeaders);
			if(bearerToken !== undefined) requestHeaders["Authorization"] = bearerToken;
			let opts = {
				method: "POST",
				credentials: "include",
				headers: requestHeaders,
				body: JSON.stringify({
					query: `query getCustomerById($input: Int!) { getCustomerById(input: $input)${expectedReturn} }`, 
					variables: {
						"input": input
					}, 
					operationName: "getCustomerById"
				})
			};
			return await (await fetch(apiUrl, opts)).json();
	},

	async createCustomer(input, expectedReturn, customHeaders){
			let requestHeaders = { "Content-Type": "application/json" }
			if(customHeaders !== undefined) requestHeaders = Object.assign({}, requestHeaders, customHeaders);
			if(bearerToken !== undefined) requestHeaders["Authorization"] = bearerToken;
			let opts = {
				method: "POST",
				credentials: "include",
				headers: requestHeaders,
				body: JSON.stringify({
					query: `mutation createCustomer($input: CustomerInput) { createCustomer(input: $input)${expectedReturn} }`, 
					variables: {
						"input": input
					}, 
					operationName: "createCustomer"
				})
			};
			return await (await fetch(apiUrl, opts)).json();
	},

	async createCustomerOrder(input, expectedReturn, customHeaders){
			let requestHeaders = { "Content-Type": "application/json" }
			if(customHeaders !== undefined) requestHeaders = Object.assign({}, requestHeaders, customHeaders);
			if(bearerToken !== undefined) requestHeaders["Authorization"] = bearerToken;
			let opts = {
				method: "POST",
				credentials: "include",
				headers: requestHeaders,
				body: JSON.stringify({
					query: `mutation createCustomerOrder($input: CustomerOrderInput) { createCustomerOrder(input: $input)${expectedReturn} }`, 
					variables: {
						"input": input
					}, 
					operationName: "createCustomerOrder"
				})
			};
			return await (await fetch(apiUrl, opts)).json();
	},

	async createProducts(input, expectedReturn, customHeaders){
			let requestHeaders = { "Content-Type": "application/json" }
			if(customHeaders !== undefined) requestHeaders = Object.assign({}, requestHeaders, customHeaders);
			if(bearerToken !== undefined) requestHeaders["Authorization"] = bearerToken;
			let opts = {
				method: "POST",
				credentials: "include",
				headers: requestHeaders,
				body: JSON.stringify({
					query: `mutation createProducts($input: [ProductInput]) { createProducts(input: $input)${expectedReturn} }`, 
					variables: {
						"input": input
					}, 
					operationName: "createProducts"
				})
			};
			return await (await fetch(apiUrl, opts)).json();
	},

}