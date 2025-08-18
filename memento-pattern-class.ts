abstract class Command<State> {
    abstract execute(state: State): State;
}



class CommandStack<State> {
    private stack: Command<State>[] = []
    constructor(private _state: State) {

    }


    get state() {
        return this._state;
    }

    execute(command: Command<State>) {
        this._state = command.execute(this._state);
        this.stack.push(command);

    }

    undo() {
        const command = this.stack.pop();
        if (command) {
            this._state = command.undo(this._state);
        }
    }

    setState(values: State) {
        this._state = values
    }
}



class AddOne extends Command<number> {
    execute(state: number): number {
        return state + 1
    }
    undo(state: number): number {
        return state - 1
    }
}

const commandStack = new CommandStack<number>(0);
console.log(commandStack.state)

commandStack.execute(new AddOne())

console.log(commandStack.state)
commandStack.undo()
console.log(commandStack.state)


class ManageNames extends Command<string[]> {

    constructor(private value: string) {
        super();
    }


    execute(state: string[]): string[] {
        state.push(this.value)
        return state
    }
    undo(state: string[]): string[] {
        state.pop()
        return state
    }
}

const cs = new CommandStack<string[]>([])
cs.setState(['123','rakib'])
console.log(cs.state)
// cs.execute(new ManageNames('rakib'))
// cs.execute(new ManageNames('pain'))
cs.execute(new ManageNames('minato'))
console.log(cs.state)

// cs.undo()
cs.undo()



console.log(cs.state)
             