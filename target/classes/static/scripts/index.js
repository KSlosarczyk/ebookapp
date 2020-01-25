document.addEventListener("DPMContentReady", () =>{

})

function getProducts(){
    return fetch("/api/products")
        .then((response) => response.json())
    .catch((error) => console.log(error))
}
function  toProductHtmlTemplate(product) {
    return `
    <li>
        <h2>${product.title}</h2>
        <span>${product.description}</span>
        <img src="${product.cover}"/>
        <span>${product.price}</span>span>
        <button data-product-id="${product.id}">Add basket</button>
    </li>
`;

}
function toHtmlElement(templateStr){
    let htmlElement = document.createElement('div');
    htmlElement.innerHTML = templateStr.trim();
    return htmlElement.firstChild;
}

function initalizeAddToBasket(htmlElement) {
    htmlElement.querySelector('button').addEventListener('click', () =>{
        const productId = e.target.getAttribute('data-product-id');
        console.log(`I'm going to add product with id ${productId}`);
    });
    return htmlElement;

}

(() => {
    const productListEl$ = document.querySelector('.product-list');
getProducts().then((products) => {
    products
        .map(p => toProductHtmlTemplate(p))
        .map(htmlStr => toHtmlElement(htmlStr))
            .map(elem => initalizeAddToBasket(elem))
        .forEach((element) =>{
            productListEl$.appendChild(element);
        })

    console.log(products)
})
})();