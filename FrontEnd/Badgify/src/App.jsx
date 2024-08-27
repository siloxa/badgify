import Layout from './components/layout/Layout';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Home from './components/template/Home';
import Donate from './components/template/Donate';
import Developer from './components/template/Developer';
import Opensource from './components/template/Opensource';
import Badge from './components/template/Badge';
import Createbadge from './components/template/Createbadge';
import LayoutAdmin from './components/layout/LayoutAdmin';
import AuthProvider from './providers/AuthProvider';
import ProtectedRoute from './components/layout/ProtectedRoute';

function App() {
  return (
    <BrowserRouter>
      {/* <AuthProvider> */}
        <Routes>
          <Route path="/" element={<Layout />}>
            <Route index={true} element={<Home />} />
            <Route path="/donate" element={<Donate />} />
            <Route path="/developer" element={<Developer />} />
            <Route path="/opensource" element={<Opensource />} />
          </Route>
          {/* <Route path="/badge" element={<ProtectedRoute />}> */}
            <Route path="/badge" element={<LayoutAdmin />}>
              <Route index={true} element={<Badge />} />
              <Route path="/badge/create" element={<Createbadge />} />
            </Route>
          {/* </Route> */}
        </Routes>
      {/* </AuthProvider> */}
    </BrowserRouter>
  );
}

export default App;
