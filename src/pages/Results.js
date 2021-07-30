import React from 'react'
import { BarChart, Bar, XAxis, ResponsiveContainer } from 'recharts'
import useCharts from '../hooks/use-charts'

const Results = () => {
    const data = useCharts()

    return (
        <div className='container display__col'>
            <h1>RESULTADOS</h1>
            <ResponsiveContainer width='95%' height='50%'>
                <BarChart width={150} height={40} data={data}>
                    <XAxis dataKey='type' />
                    <Bar dataKey='total' barSize={50} />
                </BarChart>
            </ResponsiveContainer>
        </div>
    )
}

export default Results
