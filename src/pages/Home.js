import React from 'react'
import { Link } from 'react-router-dom'

const Home = () => {
    return (
        <div className="container">
            <div className="display__col">
                <h1>Bienvenido a Encuesta 3it</h1>
                <Link to="/quiz">
                    <button>Comenzar</button>
                </Link>

            </div>
        </div>
    )
}

export default Home
