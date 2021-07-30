import React, { useEffect, useState } from 'react'
import Select from '../components/Select'
import typesService from '../services/types'
import { useHistory } from "react-router-dom"
import * as ROUTES from '../constants/routes'

const Quiz = () => {
    const [data, setData] = useState([])
    const [selectedType, setSelectedType] = useState(null);
    const [email, setEmail] = useState(null);
    const history = useHistory()

    useEffect(() => {
        async function getData() {
            const data = await typesService.getTypes()
            setData(data)
            setSelectedType(data[0].name)
        }
        getData()
    }, [])

    const sendQuiz = async () => {
        // eslint-disable-next-line no-restricted-globals
        event.preventDefault()

        if (!selectedType) return window.alert('Debes seleccionar un estilo músical.')
        if (!email) return window.alert('Debes ingresar tu correo electrónico.')

        const response = await typesService.create({
            email,
            type: selectedType
        })

        window.alert(response)

        history.push(ROUTES.RESULTS)
    }

    const handleSelectedType = (type) => setSelectedType(type)

    return (
        <div className="container display__col">
            <h1>Encuesta 3it</h1>
            <form className="display__col" onSubmit={sendQuiz}>
                <Select types={data} handleSelectedType={handleSelectedType} />
                <h4>CORREO ELECTRÓNICO</h4>
                <input
                    placeholder="Escribe aquí..."
                    value={email}
                    onChange={({ target }) => setEmail(target.value)} />
                <button type="submit">Enviar</button>
            </form>
        </div>
    )
}

export default Quiz
