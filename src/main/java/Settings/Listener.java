package Settings;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Listener extends SettingBase {
	
	private final Transport m_Transport; 
	
	public Listener(Transport transport)
	{
		m_Transport = transport;
	}
	public Transport getTransport() { return m_Transport; }
	
	public static Listener CreateFromNode(Node node)
	{
		if(node == null)
			return null;
		
		Listener objOut = null;
		NodeList nodeList = node.getChildNodes();
		for(int i = 0; objOut == null && i < nodeList.getLength(); i++)
		{
			Node nodeItem = nodeList.item(i);
			if(nodeItem.getNodeName().compareTo("Transport") == 0)
			{
				objOut = new Listener(Transport.CreateFromNode(nodeItem));
			}
		}
		objOut.FillFromNode(node);		
		
		return objOut;
	}
}
