import sofia.micro.jeroo.*;

//-------------------------------------------------------------------------
/**
 *  This jeroo will pick flowers and disable nets.
 *
 *  @author Mykayla Fernandes (mkaykay1)
 *  @version 2015.09.10
 */
public class NetRemover extends Jeroo
{
    //~ Fields ................................................................



    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new NetRemover object.
     * @param x         The x-coordinate of the jeroo's location.
     * @param y         The y-coordinate of the jeroo's location.
     */
    public NetRemover(int x, int y)
    {
        super(x, y);
    }


    //~ Methods ...............................................................
    /**
     * sees flowers
     * picks flowers
     * sees water
     * avoids water
     * finds nets
     * disables nets
     * if there are no flowers, stop
     */
    public void myProgram()
    {
        //sees flowers. pick them
        this.pickFlowers();
        
        //sees nets. disable them
        this.disableNets();
        
        //navigate around water
        this.navigateWater();
        
        //no more flowers. stop
    }
    /**
     * pick up flowers when it sees them
     */
    public void pickFlowers()
    {
        while (this.seesFlower(RIGHT) )
        {
            this.turn(RIGHT);
            this.hop();
            this.pick();
        }
        while (this.seesFlower(AHEAD) )
        {
            this.hop();
            this.pick();
        }
        if (this.isClear(LEFT) )
        {
            this.turn(LEFT);
        }
    }
    /**
     * toss flowers and disable nets while it has flowers
     */
    public void disableNets()
    {
        while (this.isClear(AHEAD) )
        {
            this.hop();
        }
        if (this.seesNet(AHEAD) )
        {
            this.toss();
            this.hop();
        }
        if (this.seesNet(LEFT) )
        {
            this.turn(LEFT);
            while (this.seesNet(AHEAD) )
            {
                this.toss();
                this.hop();
                if (!this.hasFlower() )
                {
                    this.turn(LEFT);
                }
            }
        }
    }
    /**
     * Patrol around the perimeter of the island until it reaches nets
     */
    public void navigateWater()
    {
        while (this.seesWater(RIGHT) )
        {
            this.hop();
            if (this.seesWater(AHEAD) )
            {
                this.turn(LEFT);
            }
        }
        }
    }
    
