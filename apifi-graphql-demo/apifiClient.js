let apiUrl = location.origin + '/graphql';
let bearerToken = undefined;

export default {

    setBearerToken(token) {
        bearerToken = token;
    },

    setApiUrl(url) {
        apiUrl = url;
    },

    async getAuthorById(input, expectedReturn, customHeaders) {
        let requestHeaders = {"Content-Type": "application/json"}
        if (customHeaders !== undefined) requestHeaders = Object.assign({}, requestHeaders, customHeaders);
        if (bearerToken !== undefined) requestHeaders["Authorization"] = bearerToken;
        let opts = {
            method: "POST",
            credentials: "include",
            headers: requestHeaders,
            body: JSON.stringify({
                query: `query getAuthorById($input: Int!) { getAuthorById(input: $input)${expectedReturn} }`,
                variables: {
                    "input": input
                },
                operationName: "getAuthorById"
            })
        };
        return await (await fetch(apiUrl, opts)).json();
    },

    async createAuthor(input, expectedReturn, customHeaders) {
        let requestHeaders = {"Content-Type": "application/json"}
        if (customHeaders !== undefined) requestHeaders = Object.assign({}, requestHeaders, customHeaders);
        if (bearerToken !== undefined) requestHeaders["Authorization"] = bearerToken;
        let opts = {
            method: "POST",
            credentials: "include",
            headers: requestHeaders,
            body: JSON.stringify({
                query: `mutation createAuthor($input: AuthorInput) { createAuthor(input: $input)${expectedReturn} }`,
                variables: {
                    "input": input
                },
                operationName: "createAuthor"
            })
        };
        return await (await fetch(apiUrl, opts)).json();
    },

    async associateBlogPostsWithAuthor(owner, input, expectedReturn, customHeaders) {
        let requestHeaders = {"Content-Type": "application/json"}
        if (customHeaders !== undefined) requestHeaders = Object.assign({}, requestHeaders, customHeaders);
        if (bearerToken !== undefined) requestHeaders["Authorization"] = bearerToken;
        let opts = {
            method: "POST",
            credentials: "include",
            headers: requestHeaders,
            body: JSON.stringify({
                query: `mutation associateBlogPostsWithAuthor($owner: AuthorInput, $input: [BlogPostInput]) { associateBlogPostsWithAuthor(owner: $owner, input: $input)${expectedReturn} }`,
                variables: {
                    "owner": owner,
                    "input": input
                },
                operationName: "associateBlogPostsWithAuthor"
            })
        };
        return await (await fetch(apiUrl, opts)).json();
    },

}