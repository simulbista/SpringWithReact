import {useLayoutEffect, useState} from "react";


const Vendors = () =>{
    const [vendors, setVendors] = useState([]);

    useLayoutEffect(() => {
        const getVendors = async() => {
            const response = await fetch('/api/vendors/');
            const vendors = await response.json();
            setVendors(vendors);
        }

        getVendors().catch(e => {
            console.log('error fetching vendors data: ' + e);
        })
    });

    return(
        <table border='1px'>
            <thead>
                <tr>
                    <td>ID</td>
                    <td>Name</td>
                    <td>Contact</td>
                    <td>Email Address</td>
                    <td>Phone Number</td>
                    <td>Address</td>
                </tr>
            </thead>
            <tbody>
                {vendors.map(vendor =>{
                    const {vendorId, name, contact, emailAddress, phoneNumber, address} = vendor;
                    return(
                        <tr key={vendorId}>
                            <td>{vendorId}</td>
                            <td>{name}</td>
                            <td>{contact}</td>
                            <td>{emailAddress}</td>
                            <td>{phoneNumber}</td>
                            <td>{address}</td>
                        </tr>
                    );
                })}
            </tbody>
        </table>
    );

}

export default Vendors;