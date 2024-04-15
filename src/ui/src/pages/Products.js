import {useLayoutEffect, useState} from "react";


const Products = () => {
    const [products, setProducts] = useState([]);
    // to get vendor name from vendor id, lets create a map with key as id and vendor object as name
    const [vendors, setVendors] = useState(new Map());

    //adds new key-value pair to the map everytime its called
    const add = (key, value) => {
        setVendors(prev => new Map([...prev, [key, value]]));
    }

    useLayoutEffect(() => {

        const getProducts = async () => {
            const response = await fetch('/api/products/');
            const products = await response.json();
            setProducts(products);
        }

        //get vendor info and add it to the vendor map state
        const getVendors = async () => {
            const response = await fetch('/api/vendors/');
            const vendors = await response.json();

            vendors.map(vendor => {
                const {vendorId, name, contact, emailAddress, phoneNumber, address} = vendor;
                add(vendorId, vendor);
            });
        }

        getProducts().catch(e => {
            console.log('error fetching products data: ' + e);
        })

        getVendors().catch(e => {
            console.log('error fetching vendors data: ' + e);
        })

    });


    return (
        <table border='1px'>
            <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Price</th>
                <th>Vendor</th>
            </tr>
            </thead>
            <tbody>
            {products.map(product => {
                const {productId, name, price, vendorId} = product;
                //get vendorName from the vendor map state
                const vendor = vendors.get(vendorId);
                const vendorName = vendor ? vendor.name : '';
                return (
                    <tr key={productId}>
                        <td>{productId}</td>
                        <td>{name}</td>
                        <td>{price}</td>
                        <td>{vendorName}</td>
                    </tr>
                );
            })}
            </tbody>
        </table>
    );
}


export default Products;