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
	
	//���ﳵ�Ĳ���
	public String action;
	//ҵ���߼������
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
		
		//��ȡ����action����ֵ��Ϊ��
		if(request.getParameter("action") != null) {
			System.out.println("�Թ��ﳵ�в���");
			this.action = request.getParameter("action");
			
			//����������Ʒ�����ﳵ
			if(action.equals("add")) {
				//��ӳɹ���ת��success.jsp
				System.out.println("�����Ʒ");
				if(addToCart(request, response)) {
					System.out.println("�ѳɹ������Ʒ");
					request.getRequestDispatcher("/success.jsp").forward(request, response);
				}else {
					System.out.println("�����Ʒʧ��");
					request.getRequestDispatcher("/failure.jsp").forward(request, response);
				}
			}
			
			//����ǲ鿴���ﳵ
			if(action.equals("show")) {
				request.getRequestDispatcher("/cart.jsp").forward(request, response);
			}
			
			//�����ִ��ɾ������
			if(action.equals("delete")) {
				if(deleteFromCart(request, response)) {
					System.out.println("ɾ��ʧ��");
					request.getRequestDispatcher("/cart.jsp").forward(request, response);
				}else {
					System.out.println("ɾ���ɹ�");
					request.getRequestDispatcher("/cart.jsp").forward(request, response);
				}
			}
		}
	}
	
	/*
	 * ���ָ����Ʒ�����ﳵ
	 * ��Ʒid��request�л�ȡ��
	 * Ȼ�����Cart�����ӽ����ﳵ������ӽ�ȥ
	 */
	public boolean addToCart(HttpServletRequest request, HttpServletResponse response) {
		//��ȡrequest�д�������id��num
		String id = request.getParameter("id");
		String num = request.getParameter("num");
		
		System.out.println("��Ʒid:" + id);
		System.out.println("��Ʒnum:" + num);
		
		//ͨ���õ���id��ȡһ��Item����
		Item item = iDao.getItemById(Integer.parseInt(id));
		
		/*
		 * �Ƿ��ǵ�һ�θ����ﳵ�������Ʒ
		 * ���ǵ�һ�������Ʒ��Ҫ��session�д���һ��Cart����
		 * ����������cart�������session��
		 */
		if(request.getSession().getAttribute("cart") == null) {
			Cart cart = new Cart();
			request.getSession().setAttribute("cart", cart);
		}
		
		//����һ��Cart���󣬴�session�еõ���Attribute
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		
		//�ж��Ƿ���ӳɹ�
		if(cart.addGoodsInCart(item, Integer.parseInt(num))) {
			return true;
		}else {
			return false;
		}
		
	}
	
	/*
	 * �ӹ��ﳵ��ɾ��ָ����Ʒ
	 * ��Ʒid��request�л�ȡ��
	 * Ȼ�����Cart���ɾ����Ʒ��������ɾ������
	 */
	public boolean deleteFromCart(HttpServletRequest request, HttpServletResponse response) {
		/*
		 * ��request�л�ȡid Cart,
		 * ��ͨ��cart�����ȡitem������itemsDao�еķ����������ɾ��
		 */
		String id = request.getParameter("id");
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		Item item = iDao.getItemById(Integer.parseInt(id));
		
		//�ж��Ƿ�ɾ���ɹ�
		if(cart.removeGoodsFromCart(item)) {
			return true;
		}else {
			return false;
		}
		
	}
	
}
