public class MediumNew extends ElasticERL{ 
    //node class that defines BST node
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

    // BST root node 
    TreeNode root; 
  
   // Constructor for BST =>initial empty tree
    MediumNew(){ 
        root = null; 
    } 
    //delete a node from BST
    void deleteKey(int key) { 
        root = delete_Recursive(root, key); 
    } 
   
    //recursive delete function
    TreeNode delete_Recursive(TreeNode root, int key)  { 
        //tree is empty
        if (root == null)  return root; 
   
        //traverse the tree
        if (key < root.key)     //traverse left subtree 
            root.left = delete_Recursive(root.left, key); 
        else if (key > root.key)  //traverse right subtree
            root.right = delete_Recursive(root.right, key); 
        else  { 
            // node contains only one child
            if (root.left == null) 
                return root.right; 
            else if (root.right == null) 
                return root.left; 
   
            // node has two children; 
            //get inorder successor (min value in the right subtree) 
            root.key = minValue(root.right); 
   
            // Delete the inorder successor 
            root.right = delete_Recursive(root.right, root.key); 
        } 
        return root; 
    } 
   
    int minValue(TreeNode root)  { 
        //initially minval = root
        int minval = root.key; 
        //find minval
        while (root.left != null)  { 
            minval = root.left.key; 
            root = root.left; 
        } 
        return minval; 
    } 
   
    // insert a node in BST 
    void insert(int key, String value)  { 
        root = insert_Recursive(root, key, value); 
    } 
   
    //recursive insert function
    TreeNode insert_Recursive(TreeNode root, int key, String value) { 
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
          // return pointer
        return root; 
    } 
 
    //inorder traversal of BST 
    void inorder() { 
        inorder_Recursive(root); 
    }
   
    // recursively traverse the BST  
    void inorder_Recursive(TreeNode root) { 
        if (root != null) { 
            inorder_Recursive(root.left); 
            System.out.print(root.key + " - "+ root.value + " | "); 
            inorder_Recursive(root.right); 
        } 
    } 
     
    String search(int key)  { 
        root = search_Recursive(root, key); 
        System.out.println("eeee: "+root.value);
        if (root!= null)
            return root.value;
        else
            return "Key was not found in the ADT.";
    } 
   
    //recursive insert function
    TreeNode search_Recursive(TreeNode root, int key)  { 
        // Base Cases: root is null or key is present at root 
        if (root==null || root.key==key) 
        {
            System.out.println("FOUNDDD" + root.value);
            return root; 
        }
            
        // val is greater than root's key 
        if (root.key > key) 
            return search_Recursive(root.left, key); 
        // val is less than root's key 
        return search_Recursive(root.right, key); 
    } 
}
