const React = require('react');
const client = require('../client');
const { Link, useParams} = require('react-router-dom');
const {useState, useEffect} = require('react');



const PageVerDetalle = (props) => {

    // const id = props.match.params.id;
    let { id } = useParams();
    const [detalles, setDetalles] = useState({});
    const [productName, setProductName] = useState('');

    useEffect(() => {
        client({
            method: 'GET',
            path: '/api/ventaDetalles/' + id
        }).done(response => {
            setDetalles(response.entity);
        });
        client({
            method: 'GET',
            path: '/api/ventaDetalles/+' + id+'/producto'
        }).done(response => {
            setProductName(response.entity);
        });
    }, []);


    return (
        <>
            <h1>Ver Detalles de Venta</h1>
            <table border={1}>
                <tr>
                    <th>Id de la Venta :</th>
                    <td>{id}</td>
                </tr>
                <tr>
                    <th>Precio Unitario :</th>
                    <td>{productName.precio}</td>
                </tr>
                
                <tr>
                    <th>Cantidad :</th>
                    <td>{detalles.cantidad}</td>
                </tr>
                <tr>
                    <th>Producto :</th>
                    <td>{productName.nombre}</td>
                </tr>
                <tr>
                    <th>Total :</th>
                    <td>{detalles.cantidad*productName.precio}</td>
                </tr>
            </table>

            <Link to="/">Volver</Link>
        </>
    )
}

module.exports = PageVerDetalle;