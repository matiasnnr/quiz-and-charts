import React from 'react'

const Select = ({ types, handleSelectedType }) => {

    return (
        <div className="display__col">
            <h4>ESTILO MÚSICAL</h4>
            <select
                id="types"
                onChange={({ target }) => handleSelectedType(target.value)}
            >
                {
                    types.length > 0 &&
                    types.map(({ id, name }) => <option key={id} value={name}>{name}</option>)
                }
            </select>
        </div>
    )
}

export default Select
