import Layout from './components/layout/Layout';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Home from './components/template/Home';
import Donate from './components/template/Donate';
import Developer from './components/template/Developer';
import Opensource from './components/template/Opensource';
import Badg from './components/template/Badg';
function App() {
  return (
      <BrowserRouter>
        <Routes>
          <Route path='/' element={<Layout/>}>
            <Route path="/" element={<Home />} />
            <Route path="/donate" element={<Donate />} />
            <Route path="/developer" element={<Developer />} />
            <Route path="/opensource" element={<Opensource />} />
            <Route path='/badg' element={<Badg/>}  />
          </Route>
        </Routes>
      </BrowserRouter>
  );
}

export default App;
