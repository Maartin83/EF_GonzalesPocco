const React = require('react');
const client = require('../client');
const { Link, useParams} = require('react-router-dom');
const {useState, useEffect} = require('react');



const PageVerProducto = (props) => {

    // const id = props.match.params.id;
    let { id } = useParams();
    const [producto, setProducto] = useState({});

    useEffect(() => {
        client({
            method: 'GET',
            path: '/api/productos/' + id
        }).done(response => {
            setProducto(response.entity);
        });
    }, []);


    return (
        <>
            <h1>Ver Producto</h1>
            <table border={1}>
                <tr>
                    <th>Descripcion del Producto :</th>
                    <td>{producto.nombre}</td>
                </tr>
                <tr>
                    <th>Precio del Producto :</th>
                    <td>{producto.precio}</td>
                </tr>
            </table>

            <Link to="/">Volver</Link>
        </>
    )
}

module.exports = PageVerProducto;