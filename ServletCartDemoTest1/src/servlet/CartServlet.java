package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.itemsDao;
import entity.Cart;
import entity.Item;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//购物车的操作
	public String action;
	//业务逻辑类对象
	public itemsDao iDao = new itemsDao();
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//获取到的action参数值不为空
		if(request.getParameter("action") != null) {
			System.out.println("对购物车有操作");
			this.action = request.getParameter("action");
			
			//如果是添加商品进购物车
			if(action.equals("add")) {
				//添加成功跳转至success.jsp
				System.out.println("添加商品");
				if(addToCart(request, response)) {
					System.out.println("已成功添加商品");
					request.getRequestDispatcher("/success.jsp").forward(request, response);
				}else {
					System.out.println("添加商品失败");
					request.getRequestDispatcher("/failure.jsp").forward(request, response);
				}
			}
			
			//如果是查看购物车
			if(action.equals("show")) {
				request.getRequestDispatcher("/cart.jsp").forward(request, response);
			}
			
			//如果是执行删除操作
			if(action.equals("delete")) {
				if(deleteFromCart(request, response)) {
					System.out.println("删除失败");
					request.getRequestDispatcher("/cart.jsp").forward(request, response);
				}else {
					System.out.println("删除成功");
					request.getRequestDispatcher("/cart.jsp").forward(request, response);
				}
			}
		}
	}
	
	/*
	 * 添加指定商品进购物车
	 * 商品id从request中获取，
	 * 然后调用Cart类的添加进购物车方法添加进去
	 */
	public boolean addToCart(HttpServletRequest request, HttpServletResponse response) {
		//获取request中传过来的id和num
		String id = request.getParameter("id");
		String num = request.getParameter("num");
		
		System.out.println("商品id:" + id);
		System.out.println("商品num:" + num);
		
		//通过得到的id获取一个Item对象
		Item item = iDao.getItemById(Integer.parseInt(id));
		
		/*
		 * 是否是第一次给购物车中添加商品
		 * 若是第一次添加商品则要给session中创建一个Cart对象
		 * 并将创建的cart对象放入session中
		 */
		if(request.getSession().getAttribute("cart") == null) {
			Cart cart = new Cart();
			request.getSession().setAttribute("cart", cart);
		}
		
		//创建一个Cart对象，从session中得到的Attribute
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		
		//判断是否添加成功
		if(cart.addGoodsInCart(item, Integer.parseInt(num))) {
			return true;
		}else {
			return false;
		}
		
	}
	
	/*
	 * 从购物车中删除指定商品
	 * 商品id从request中获取，
	 * 然后调用Cart类的删除商品方法进行删除操作
	 */
	public boolean deleteFromCart(HttpServletRequest request, HttpServletResponse response) {
		/*
		 * 从request中获取id Cart,
		 * 再通过cart对象获取item，调用itemsDao中的方法对其进行删除
		 */
		String id = request.getParameter("id");
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		Item item = iDao.getItemById(Integer.parseInt(id));
		
		//判断是否删除成功
		if(cart.removeGoodsFromCart(item)) {
			return true;
		}else {
			return false;
		}
		
	}
	
}
