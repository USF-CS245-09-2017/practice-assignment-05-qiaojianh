/*
	@Qiaojian Hu
*/
public class BSTree{

	private BSTNode root;
			
	public void insert(String value ){
		root = insert(value, root);
	}

	private BSTNode insert(String value ,BSTNode node){
		if(node==null){
			node = new BSTNode(value);
			return node;
		}
		if(value.compareTo(node.getData())<0){
			node.setLeft(insert(value,node.getLeft()));
		}else{
			node.setRight(insert(value,node.getRight()));
		}
		return node;
	}

	public boolean find(String value){
		return find(value,root);
	}

	public boolean find(String value, BSTNode node){
		if(node == null){
			return false;
		}
		if(value.compareTo(node.getData())==0){
			return true;
		}else if(value.compareTo(node.getData())<0){
			return find(value,node.getLeft());
		}else{
			return find(value,node.getRight());
		}
	}

	public void delete (String value){
		root = delete(root,value);
	}

	public BSTNode delete(BSTNode node,String value){
		if(node == null){
			return null;
		}else if(value.compareTo(node.getData())<0){
			node.setLeft(delete(node.getLeft(),value));
		}else if(value.compareTo(node.getData())>0) {
			node.setRight(delete(node.getRight(),value));
		}else{

			if (node.getLeft() == null && node.getRight() == null ) {
				node=null;
			}
			else if (node.getLeft() == null) {
				node = node.getRight();
			}
			else if (node.getRight() == null ) {
				node = node.getLeft();
			}
			else{
				node = removeSmallest(node.getRight());
			}	
		}	
		return node;
	}

	public BSTNode removeSmallest(BSTNode node){
		if(node.getLeft().getLeft()==null){
			node.setLeft(node.getLeft().getRight());
			return node;
		}else{
			return removeSmallest(node.getLeft());
		}
	}

	public String toStringInOrder(){
		return toStringInOrder(root,"").trim();
	}

	public String toStringInOrder(BSTNode node, String s){
		String val = "";
		if ( node  !=   null ){		
          	val += toStringInOrder(node.getLeft(),s);
            val += s + node.getData() + " ";
            val += toStringInOrder(node.getRight(),s);           
        } 
        return val;     
	}

	public String toStringPreOrder(){
		return toStringPreOrder(root,"").trim();
	}

	public String toStringPreOrder(BSTNode node, String s){
		String val = "";
		 if ( node  !=   null )
         {
             val += s + node.getData() + " "; 
             val += toStringPreOrder(node.getLeft(),s);
             val += toStringPreOrder(node.getRight(),s);  
         } 
         return val;
	}
}