import {useLayoutEffect, useState} from "react";


const Services = () => {
    const [services, setServices] = useState([]);

    useLayoutEffect(() => {
        const getServices = async () => {
            const responses = await fetch('/api/services/');
            const services = await responses.json();
            setServices(services);
        }

        getServices().catch(e => {
            console.log('error fetching services data: ' + e);
        });

    });


    return (
        <table border='1px'>
            <thead>
            <tr>
                <td>ID</td>
                <td>Price</td>
                <td>Name</td>
            </tr>
            </thead>
            <tbody>
            {services.map(service => {
                const {serviceId, price, name} = service;
                return (
                    <tr key={serviceId}>
                        <td>{serviceId}</td>
                        <td>{price}</td>
                        <td>{name}</td>
                    </tr>
                )
            })}
            </tbody>
        </table>
    );

}

export default Services;