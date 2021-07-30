import React from 'react'
import { Link } from 'react-router-dom'
import './Navbar.css'

const Navbar = () => {

    const handleCheckBox = () => {
        document.getElementById("nav-check").checked = false;
    }

    return (
        <div className="nav">
            <input type="checkbox" id="nav-check" />
            <div className="nav-header">
                <div className="nav-title">
                    Encuesta 3it
                </div>
            </div>
            <div className="nav-btn">
                <label for="nav-check">
                    <span></span>
                    <span></span>
                    <span></span>
                </label>
            </div>

            <div className="nav-links">
                <Link to="/" onClick={handleCheckBox}>Inicio</Link>
                <Link to="/quiz" onClick={handleCheckBox}>Encuesta</Link>
                <Link to="/results" onClick={handleCheckBox}>Resultados</Link>
                <Link to="/about" onClick={handleCheckBox}>Acerca de</Link>
            </div>
        </div>
    )
}

export default Navbar
