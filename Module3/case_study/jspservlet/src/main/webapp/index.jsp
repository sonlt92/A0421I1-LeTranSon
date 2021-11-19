<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Furama resort</title>
  <link rel="stylesheet" href="css/bootstrap.min.css">
  <link rel="stylesheet" href="css/mdb.min.css">
  <link rel="stylesheet" href="css/style.css">
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.3/css/all.css" integrity="sha384-SZXxX4whJ79/gErwcOYf+zWLeJdY/qpuqC4cAa9rOGUstPomtqpuNWT9wdPEn2fk" crossorigin="anonymous">
</head>
<body>
<!--Main nav-->
<header>
  <!-- Navbar -->
  <nav id="bg-nav" class="navbar navbar-expand-lg navbar-light bg-light fixed-top">
    <!-- Container wrapper -->
    <div class="container-fluid">
      <!-- Navbar brand -->
      <a class="navbar-brand" href="/">
        <img src="img/logo.png" alt="">
      </a>

      <!-- Toggle button -->
      <button
              class="navbar-toggler"
              type="button"
              data-mdb-toggle="collapse"
              data-mdb-target="#navbarSupportedContent"
              aria-controls="navbarSupportedContent"
              aria-expanded="false"
              aria-label="Toggle navigation"
      >
        <i class="fas fa-bars"></i>
      </button>

      <!-- Collapsible wrapper -->
      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <!-- Left links -->
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
          <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="/">Home</a>
          </li>
          <!-- Navbar dropdown -->
          <li class="nav-item dropdown">
            <a
                    class="nav-link dropdown-toggle"
                    href="#"
                    id="navbarDropdownEmployee"
                    role="button"
                    data-mdb-toggle="dropdown"
                    aria-expanded="false"
            >
              Employee
            </a>
            <!-- Dropdown menu -->
            <ul class="dropdown-menu" aria-labelledby="navbarDropdownEmployee">
              <li><a class="dropdown-item" href="/employee?actionUser=addNewEmployee">Add new employee</a></li>
              <li><a class="dropdown-item" href="/employee?actionUser=displayEmployee">Display employee</a></li>
            </ul>
          </li>
          <li class="nav-item dropdown">
            <a
                    class="nav-link dropdown-toggle"
                    href="#"
                    id="navbarDropdownCus"
                    role="button"
                    data-mdb-toggle="dropdown"
                    aria-expanded="false"
            >
              Customer
            </a>
            <!-- Dropdown menu -->
            <ul class="dropdown-menu" aria-labelledby="navbarDropdownCus">
              <li><a class="dropdown-item" href="/customer?actionUser=addNewCustomer">Add new customer</a></li>
              <li><a class="dropdown-item" href="/customer?actionUser=displayCustomer">Display customer</a></li>
            </ul>
          </li>
          <li class="nav-item dropdown">
            <a
                    class="nav-link dropdown-toggle"
                    href="#"
                    id="navbarDropdownServices"
                    role="button"
                    data-mdb-toggle="dropdown"
                    aria-expanded="false"
            >
              Service
            </a>
            <!-- Dropdown menu -->
            <ul class="dropdown-menu" aria-labelledby="navbarDropdownServices">
              <li><a class="dropdown-item" href="/service?actionUser=addNewService">Add new service</a></li>
              <li><a class="dropdown-item" href="/service?actionUser=displayService&index=1">Display service</a></li>
            </ul>
          </li>
          <li class="nav-item dropdown">
            <a
                    class="nav-link dropdown-toggle"
                    href="#"
                    id="navbarDropdownContract"
                    role="button"
                    data-mdb-toggle="dropdown"
                    aria-expanded="false"
            >
              Contract
            </a>
            <!-- Dropdown menu -->
            <ul class="dropdown-menu" aria-labelledby="navbarDropdownContract">
              <li><a class="dropdown-item" href="/contract?actionUser=addNewContract">Add new contract</a></li>
              <li><a class="dropdown-item" href="/contract?actionUser=addNewContractDetail">Add new contract detail</a></li>
            </ul>
          </li>
        </ul>
        <!-- Left links -->
        <!-- Search form -->
        <form class="d-flex input-group w-auto">
          <input
                  type="search"
                  class="form-control btn-rounded"
                  placeholder="Search..."
                  aria-label="Search"
          />
          <button
                  class="btn btn-outline-primary border"
                  type="button"
                  data-mdb-ripple-color="dark"
          >
            <i class="fas fa-search"></i>
          </button>
        </form>
        <a data-toggle="modal" data-target="#exampleModal" class="nav-link" href="#" data-mdb-toggle="tooltip" title="Login">
          <svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="currentColor" class="bi bi-person-circle" viewBox="0 0 16 16">
            <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
            <path fill-rule="evenodd" d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"/>
          </svg>
        </a>
      </div>
      <!-- Collapsible wrapper -->
    </div>
    <!-- Container wrapper -->
  </nav>
  <!-- Navbar -->
  <!--Mask-->
  <div id="intro" class="view ">
    <div class="mask container-fluid d-flex justify-content-center align-items-center full-bg-img" style="background-color: rgba(0, 0, 0, 0.6)">
      <div class="row d-flex justify-content-center">
        <div class="col-1-lg"></div>
        <div class="col-10-lg text-center mt-lg-5">
          <h2 class="display-5 font-weight-bold text-white justify-content-center">
            <strong>Furama Resort</strong>
            <br>
            <strong>Da Nang</strong>
          </h2>
          <hr class="my-4 text-white">
          <h4 class="text-white my-4">
            <strong>KHU NGHỈ DƯỠNG ẨM THỰC </strong><br>
            <strong>TỌA LẠC TẠI BÃI BIỂN ĐÀ NẴNG </strong><br>
            <strong>MỘT TRONG 6 BÃI BIỂN ĐẸP NHẤT THẾ GIỚI<br>
            </strong>
          </h4>
          <a href="#">
            <button type="button" class="btn btn-outline-white">
              Booking
            </button>
          </a>
        </div>
      </div>
    </div>
  </div>
  <!--Mask-->
  <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel">LOGIN</h5>
          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">&times;</span>
          </button>
        </div>
        <div class="modal-body">
          <form>
            <div class="form-group">
              <label for="exampleInputEmail1">Email address</label>
              <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
              <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
            </div>
            <div class="form-group">
              <label for="exampleInputPassword1">Password</label>
              <input type="password" class="form-control" id="exampleInputPassword1">
            </div>
            <div class="form-group form-check">
              <input type="checkbox" class="form-check-input" id="exampleCheck1">
              <label class="form-check-label" for="exampleCheck1">Check me out</label>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
          </form>
        </div>
      </div>
    </div>
  </div>
</header>
<!--Main nav-->
<!--Main layout-->
<div class="mt-lg-5">
  <div class="container">
    <!--main introduce-->
    <div class="row">
      <div class="col-lg-4">
        <h3 class="justify-content-center text-warning font-weight-bold">
          KHU NGHỈ DƯỠNG ĐẲNG CẤP THẾ GIỚI, FURAMA ĐÀ NẴNG, NỔI TIẾNG LÀ KHU NGHỈ DƯỠNG ẨM THỰC TẠI VIỆT NAM.
        </h3>
      </div>
      <div class="col-lg-4">
        <a href="#" data-toggle="modal" data-target=".bd-example-modal-lg">
          <img class="w-100" src="img/Vietnam_Danang_Furama_Resort_Exterior_Beach.jpg" alt=""/>
          <div class="justify-content-center icon-play">
            <svg xmlns="http://www.w3.org/2000/svg" width="50" height="50" fill="currentColor" class="bi bi-play-circle" viewBox="0 0 16 16">
              <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
              <path d="M6.271 5.055a.5.5 0 0 1 .52.038l3.5 2.5a.5.5 0 0 1 0 .814l-3.5 2.5A.5.5 0 0 1 6 10.5v-5a.5.5 0 0 1 .271-.445z"/>
            </svg>
          </div>
        </a>
        <div class="modal fade bd-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
          <div class="modal-dialog modal-lg">
            <div class="modal-content">
              <iframe width="900" height="506" src="https://www.youtube.com/embed/IjlT_4mvd-c" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
            </div>
          </div>
        </div>
      </div>
      <div class="col-lg-4">
        <p class="text-justify">Hướng ra bãi biển Đà Nẵng trải dài cát trắng, Furama Resort Đà Nẵng là cửa ngõ đến với 3 di sản văn hoá thế giới: Hội An (20 phút), Mỹ Sơn (90 phút) và Huế (2 tiếng. 196 phòng hạng sang cùng với 70 căn biệt thự từ hai đến bốn phòng ngủ có hồ bơi riêng đều được trang trí trang nhã, theo phong cách thiết kế truyền thống của Việt Nam và kiến trúc thuộc địa của Pháp, biến Furama thành khu nghỉ dưỡng danh giá nhất tại Việt Nam – vinh dự được đón tiếp nhiều người nổi tiếng, giới hoàng gia, chính khách, ngôi sao điện ảnh và các nhà lãnh đạo kinh doanh quốc tế.

        </p>
      </div>
    </div>
    <!--main introduce-->
    <!--            introduce services-->
    <div class="row justify-content-center text-center mt-lg-5">
      <div class="col-lg-2"></div>
      <div class="col-lg-8">
        <h3 class="text-warning">
          <strong>CÁC LOẠI PHÒNG</strong>
        </h3>
        <p>
          Khu nghỉ dưỡng có 196 phòng được thiết kế theo phong cách truyền thống Việt Nam kết hợp với phong cách Pháp, 2 tòa nhà 4 tầng có hướng nhìn ra biển, nhìn ra hồ bơi trong xanh và những khu vườn nhiệt đới xanh tươi mát. Ngoài ra, khu nghỉ dưỡng Furama còn cung cấp các liệu pháp spa, phòng xông hơi ướt, phòng xông hơi khô, dịch vụ mát-xa cạnh hồ bơi, các dịch vụ thể thao dưới nước và các lớp tập yoga và Thái Cực Quyền trên bãi biển.
        </p>
      </div>
      <div class="col-lg-2"></div>
    </div>
    <div class="row mt-lg-3">
      <div class="col-lg-12 text-center">
        <a class="nav-link text-center" href="#">VIEW ALL ROOMS</a>
      </div>
    </div>
    <div class="row">
      <div class="col-lg-2"></div>
      <div class="col-lg-8">
        <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
          <ol class="carousel-indicators">
            <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
          </ol>
          <div class="carousel-inner">
            <div class="carousel-item active">
              <img class="d-block w-100" src="img/Vietnam_Danang_Furama_Garden-Deluxe-twin-bed-F-370x239.jpg" alt="First slide">
              <div class="carousel-caption d-none d-md-block">
                <h5>PHÒNG DULEX HƯỚNG VƯỜN</h5>
                <p>Diện Tích Phòng: 43.7 mét vuông</p>
                <a href="#">
                  <button type="button" class="btn btn-outline-primary">ĐẶT PHÒNG</button>
                </a>
              </div>
            </div>
            <div class="carousel-item">
              <img class="d-block w-100" src="img/Vietnam_Danang_Furama_Ocean-Studio-Suite-F-370x239.jpg" alt="Second slide">
              <div class="carousel-caption d-none d-md-block">
                <h5>PHÒNG DULEX HƯỚNG BIỂN</h5>
                <p>Diện Tích Phòng: 43.7 mét vuông</p>
                <a href="#">
                  <button type="button" class="btn btn-outline-primary">ĐẶT PHÒNG</button>
                </a>
              </div>
            </div>
            <div class="carousel-item">
              <img class="d-block w-100" src="img/Vietnam_Danang_Furama_Ocean-Suite-Feature-370x239.jpg" alt="Third slide">
              <div class="carousel-caption d-none d-md-block">
                <h5>PHÒNG DULEX HƯỚNG VƯỜN CÓ HỒ BƠI RIÊNG</h5>
                <p>Diện Tích Phòng: 43.7 mét vuông</p>
                <a href="#">
                  <button type="button" class="btn btn-outline-primary">ĐẶT PHÒNG</button>
                </a>
              </div>
            </div>
          </div>
          <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
          </a>
          <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
          </a>
        </div>
        <div class="col-lg-2"></div>
      </div>
    </div>
    <div class="row mt-lg-3 text-center">
      <div class="col-lg-2"></div>
      <div class="col-lg-8">
        <h3 class="text-warning">
          <strong>TRẢI NGHIỆM ẨM THỰC & GIẢI TRÍ</strong>
        </h3>
        <p>Khu nghỉ dưỡng Furama Đà Nẵng là một khu nghỉ dưỡng 5 sao sang trọng, có uy tín và được xem là một trong những biểu tượng của ngành du lịch Việt Nam.</p>
      </div>
      <div class="col-lg-2"></div>
    </div>
    <div class="row mt-lg-5">
      <div class="col-lg-12">
        <div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
          <div class="carousel-inner">
            <div class="carousel-item active">
              <img class="d-block w-100" src="img/am-thuc.jpg" alt="First slide" style="filter: blur(2px) brightness(50%)">
              <div class="carousel-caption d-none d-md-block text-center">
                <h3 class="text-warning">ẨM THỰC</h3>
                <p>Trải nghiệm ẩm thực tại Khu nghỉ có sự pha trộn độc đáo các món ăn truyền thống Việt Nam với nhiều những hương vị ẩm thực châu Á, Ý và châu Âu cùng các món bò nhập khẩu thượng hạng tại đa dạng các nhà hàng, quầy bar đẳng cấp được bao quanh bởi một khu vườn nhiệt đới hay hướng mình ra biển, đón những hơi thở mát mẻ thổi về từ biển đông. .</p>
                <a href="#">
                  <button type="button" class="btn btn-outline-light">KHÁM PHÁ NGAY</button>
                </a>
              </div>
            </div>
            <div class="carousel-item">
              <img class="d-block w-100" src="img/giai-tri.jpg" alt="Second slide" style="filter: blur(2px) brightness(50%)">
              <div class="carousel-caption d-none d-md-block text-center">
                <h3 class="text-warning">GIẢI TRÍ</h3>
                <P>Biến kỳ nghỉ dưỡng năng động hơn bằng cách tham gia các hoạt động thể thao trên nước từ chèo thuyền catamaran, lướt ván buồm, chèo thuyền trên biển, lướt vát, đi xe đạp nước, trượt nước, lướt ván, chuối, dù lượn và đa dạng các hoạt động.</P>
                <a href="#">
                  <button type="button" class="btn btn-outline-light">KHÁM PHÁ NGAY</button>
                </a>
              </div>
            </div>
            <div class="carousel-item">
              <img class="d-block w-100" src="img/hoi-nghi.jpg" alt="Third slide" style="filter: blur(2px) brightness(50%)">
              <div class="carousel-caption d-none d-md-block text-center">
                <h3 class="text-warning">SỰ KIỆN</h3>
                <p>Cung hội nghị Quốc tế International Convention Palace (ICP) với phòng Hội nghị lớn sức chứa lên tới 1000 khách cùng hơn 10 phòng chức năng phụ trợ quy mô từ 50 đến 300 khách được trang bị cơ sở vật chất, thiết bị hiện đại, là địa điểm lý tưởng dành cho các đoàn MICE tổ chức hội nghị, hội thảo và sự kiện.</p>
                <a href="#">
                  <button type="button" class="btn btn-outline-light">KHÁM PHÁ NGAY</button>
                </a>
              </div>
            </div>
          </div>
          <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
          </a>
          <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
          </a>
        </div>
      </div>
    </div>
    <!--            introduce services-->
  </div>
</div>
<!--Main layout-->
<!--footer-->
<div class="container-fluid mt-lg-5" style="background-color: #8e8b8b">
  <div class="row">
    <div class="col-lg-4">
      <h3 class="text-white mt-lg-5">BẢN ĐỒ</h3>
      <iframe class="w-100 h-75" src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3834.50245898014!2d108.24769741416945!3d16.039395344498725!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x31420fdbc8cc38ef%3A0x9a6a3e31121225d2!2sFurama%20Resort%20Danang!5e0!3m2!1svi!2s!4v1619427748449!5m2!1svi!2s" style="border:0;" allowfullscreen="" loading="lazy"></iframe>
    </div>

    <div class="col-lg-4"></div>
    <div class="col-lg-4">
      <h3 class="text-white mt-lg-5">Liên hệ</h3>
      <p>105 Võ Nguyên Giáp, Ngũ Hành Sơn, Đà Nẵng, Việt Nam</p>
      <p>Tel.: 84-236-3847 333/888 * Fax: 84-236-3847 666</p>
      <p>Email: reservation@furamavietnam.com * www.furamavietnam.com</p>
      <img src="img/world-hotel-F-new.png" class="w-100"/>
      <p>GDS-Codes: Amadeus-WWDADFUR, Apollo/Galileo-WW16236, SabreWW32771, Worldspan-WWDADFU</p>
    </div>
  </div>
  <div class="row text-center">
    <div class="col-lg-12">
      <p>© 2018 Furama Resort Danang.</p>
    </div>
  </div>
</div>
<!--footer-->
<!--js-->
<script src="js/jquery-3.6.0.min.js "></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/mdb.min.js"></script>
<!--js-->
</body>
</html>
