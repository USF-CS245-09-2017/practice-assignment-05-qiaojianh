/*
	@Qiaojian Hu
*/
public class BSTNode{
	private String data;
	private BSTNode left;
	private BSTNode right;

	public BSTNode(){
		this.data = null;
		this.left = null;
		this.right = null;
	}

	public BSTNode(String data){
		this.data = data;
		this.left = null;
		this.right = null;
	}

	public BSTNode getLeft(){
		return left;
	}

	public BSTNode getRight(){
		return right;
	}

	public String getData(){
		return data;
	}

	public void setData(String data){
		this.data = data;
	}

	public void setRight(BSTNode right){
		this.right = right;
	}

	public void setLeft(BSTNode left){
		this.left = left;
	}
}