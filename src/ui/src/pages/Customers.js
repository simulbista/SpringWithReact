import React, {useLayoutEffect, useState} from 'react';

const customers = [
    {
        "customerId": 1,
        "firstName": "Cally",
        "lastName": "Reynolds",
        "emailAddress": "penatibus.et@lectusa.com",
        "phoneNumber": "(901) 166-8355",
        "address": "556 Lakewood Park, Bismarck, ND 58505"
    },
    {
        "customerId": 2,
        "firstName": "Sydney",
        "lastName": "Bartlett",
        "emailAddress": "nibh@ultricesposuere.edu",
        "phoneNumber": "(982) 231-7357",
        "address": "4829 Badeau Parkway, Chattanooga, TN 37405"
    },
    {
        "customerId": 3,
        "firstName": "Hunter",
        "lastName": "Newton",
        "emailAddress": "quam.quis.diam@facilisisfacilisis.org",
        "phoneNumber": "(831) 996-1240",
        "address": "2 Rockefeller Avenue, Waco, TX 76796"
    }];


const Customers = () =>{
    const [customers, setCustomers] = useState([]);

    useLayoutEffect(() =>{
        const getCustomers = async()=>{
            const response = await fetch('/api/customers/');
            const customers = await response.json();
            setCustomers(customers);
        }

        getCustomers().catch(e =>{
            console.log('error fetching customers data: ' + e);
        });
    })


    return(
        <table border='1px'>
            <thead>
                <th>ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email Address</th>
                <th>Phone No.</th>
                <th>Address</th>
            </thead>
            <tbody>
                {customers.map(customer =>{
                    //destructuring the array
                    const {customerId,
                        firstName,
                        lastName,
                        emailAddress,
                        phoneNumber,
                        address} = customer;
                        return(
                            <tr key={customerId}>
                                <td>{customerId}</td>
                                <td>{firstName}</td>
                                <td>{lastName}</td>
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


export default Customers;