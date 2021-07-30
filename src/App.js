import { BrowserRouter as Router, Switch } from 'react-router-dom';
import Home from './pages/Home'
import Quiz from './pages/Quiz'
import Results from './pages/Results'
import About from './pages/About'
import Layout from './components/Layout'
import RouteWrapper from './components/RouteWrapper'
import * as ROUTES from './constants/routes'

function App() {
  return (
    <Router>
      <Switch>
        <RouteWrapper path={ROUTES.QUIZ} component={Quiz} layout={Layout} />
        <RouteWrapper path={ROUTES.RESULTS} component={Results} layout={Layout} />
        <RouteWrapper path={ROUTES.ABOUT} component={About} layout={Layout} />
        <RouteWrapper path={ROUTES.DASHBOARD} component={Home} layout={Layout} />
      </Switch>
    </Router>
  );
}

export default App
