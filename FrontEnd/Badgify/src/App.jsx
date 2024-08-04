import Layout from './components/layout/Layout';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Home from './components/template/Home';
import Donate from './components/template/Donate';
import Developer from './components/template/Developer';
import Opensource from './components/template/Opensource';
function App() {
  return (
    <Layout>
      <BrowserRouter>
        <Routes>
          <Route path="/home" element={<Home />} />
          <Route path="/donate" element={<Donate />} />
          <Route path="/developer" element={<Developer />} />
          <Route path="/opensource" element={<Opensource />} />
        </Routes>
      </BrowserRouter>
    </Layout>
  );
}

export default App;
