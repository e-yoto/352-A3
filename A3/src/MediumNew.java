public class MediumNew extends ElasticERL{ 
    //node class
    class TreeNode { 
        int key;
        String value; 
        TreeNode left, right; 
   
        public TreeNode(int key, String value){ 
            this.key = key; 
            this.value = value;
            left = right = null; 
        } 
    } 

    TreeNode root; 
  
    public MediumNew(){ 
        root = null; 
    } 
   
    // insert a node in BST 
    public void insert(int key, String value)  { 
        root = insert_Recursive(root, key, value); 
    } 
   
    //recursive insert function
    public TreeNode insert_Recursive(TreeNode root, int key, String value) { 
          //tree is empty
        if (root == null) { 
            root = new TreeNode(key, value); 
            return root; 
        } 
        //traverse the tree
        if (key < root.key)     //insert in the left subtree
            root.left = insert_Recursive(root.left, key, value); 
        else if (key > root.key)    //insert in the right subtree
            root.right = insert_Recursive(root.right, key, value); 
        return root; 
    } 

    //return next key
    public int nextKey(int key)
    {
        TreeNode temp = root;
        temp = search_Recursive(root, key);

        return temp.right.key;
    }

    //return previous key
    public int prevKey(int key)
    {
        TreeNode temp = root;
        temp = search_Recursive(root, key);

        return temp.left.key;
    }
 
    //inorder traversal of BST 
    public void inorder() { 
        inorder_Recursive(root); 
    }
   
    public void inorder_Recursive(TreeNode root) { 
        if (root != null) { 
            inorder_Recursive(root.left); 
            System.out.print(root.key + " - "+ root.value + " | "); 
            inorder_Recursive(root.right); 
        } 
    } 

    //find keys within range of k1 and k2
    public int[] rangeKey(int k1, int k2)
    {
        TreeNode temp = root;
        
        if (k1 < k2)
        {
            temp = search_Recursive(root, k1);
            return rangeKey_Second(temp, k2);
        }
        else
        {
            temp = search_Recursive(root, k2);
            return rangeKey_Second(temp, k1);
        }

    }
    public int[] rangeKey_Second(TreeNode root, int key)  { 
        Small<Integer, String> list = new Small<>();
        
        while (root != null)
        {
            if (root.key > key) 
            {
                list.addLast(root.key, root.value);
                root = root.left;
            }
            else
            {
                list.addLast(root.key, root.value);
                root = root.right;
            }
        }
        
        int[] a = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
        {
            a[i] = list.get(i).key;
        }

        return a;
     } 
     
    public String search(int key)  { 
        root = search_Recursive(root, key); 
        if (root!= null)
            return root.value;
        else
            return "Key was not found in the ADT.";
    } 
   
    //recursive insert function
    public TreeNode search_Recursive(TreeNode root, int key)  { 
        if (root==null || root.key==key) 
            return root; 
            
        // val is greater than root's key 
        if (root.key > key) 
            return search_Recursive(root.left, key); 
        // val is less than root's key 
        return search_Recursive(root.right, key); 
    } 
}
