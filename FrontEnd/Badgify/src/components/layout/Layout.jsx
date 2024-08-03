import Header from "./Header"
import Footer from "./Footer"

function Layout({children}) {
  return (
    <>
      <Header />
      {children}
      <Footer />
    </>
  )
}

export default Layout
