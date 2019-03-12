package DHADVTKV;

import peersim.cdsim.CDProtocol;
import peersim.config.Configuration;
import peersim.core.Node;

/**
 * Each type plays its part on the 2PC protocol
 * @author diogofsvilela
 *
 */
public class TwoPhaseCommitProtocol implements CDProtocol {

    private final int typePid;
    private static final String PAR_TYPE_PROT = "type_protocol";

//--------------------------------------------------------------------------
// Initialization
//--------------------------------------------------------------------------

    public TwoPhaseCommitProtocol(String prefix) {
        System.out.println("Hello from 2pc protocol constructor");
        typePid = Configuration.getPid(prefix + "." + PAR_TYPE_PROT);
    }

    /**
     * A protocol which is defined by performing an algorithm in more or less
     * regular periodic intervals.
     * This method is called by the simulator engine once in each cycle with
     * the appropriate parameters.
     *
     * @param node       the node on which this component is run
     * @param protocolID
     */
    @Override
    public void nextCycle(Node node, int protocolID) {
        TypeProtocol nodeType = (TypeProtocol) node.getProtocol(typePid);
        if (nodeType.getType() == TypeProtocol.Type.DATACENTER) {
            doDatacenterMethod();
        } else if (nodeType.getType() == TypeProtocol.Type.CLIENT) {
            doClientMethod();
        } else if (nodeType.getType() == TypeProtocol.Type.COORDINATOR) {
            doCoordinatorMethod();
        } else {
            return;
        }

    }

    private void doDatacenterMethod() {
        System.out.println("Hello from Datacenter");
    }

    private void doClientMethod() {
        System.out.println("Hello from Client");
    }

    private void doCoordinatorMethod() {
        System.out.println("Hello from Coordinator");
    }

    /**
     * Returns a clone of the protocol. It is important to pay attention to
     * implement this carefully because in peersim all nodes are generated by
     * cloning except a prototype node. That is, the constructor of protocols is
     * used only to construct the prototype. Initialization can be done
     * via {@link Control}s.
     */
    @Override
    public Object clone() {
        TwoPhaseCommitProtocol inp = null;
        try {
            inp = (TwoPhaseCommitProtocol) super.clone();
        } catch (CloneNotSupportedException e) {
        } // never happens
        return inp;
    }
}